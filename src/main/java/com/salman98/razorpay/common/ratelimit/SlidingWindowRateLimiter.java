package com.salman98.razorpay.common.ratelimit;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "app.rate-limit.method", havingValue = "sliding")
public class SlidingWindowRateLimiter implements RateLimiter {

    // This is not thread-safe at the algorithm level because remove → count → check → add is a multi-command operation,
    // allowing concurrent requests to make decisions based on the same stale count.

    private final StringRedisTemplate redis;

    @Override
    public RateLimitResult check(String key, int maxRequestAllowed, long windowSeconds) {

        // 1. calculate current window
        long nowMs = System.currentTimeMillis();
        long floorMs = nowMs - windowSeconds * 1000;

        // 2. create redis key
        String redisKey = "ratelimit:sliding:" + key;

        // 3. redis sorted set
        var zset = redis.opsForZSet();

        // 4. remove old requests
        zset.removeRangeByScore(redisKey, Double.NEGATIVE_INFINITY, floorMs);

        // 5. count the requests
        Long count = zset.zCard(redisKey);
        long current = count != null ? count : 0;

        // 6. check whether the limit has already been reached
        if (current >= maxRequestAllowed) {

            // 7. find the oldest request
            var oldest = zset.rangeWithScores(redisKey, 0, 0);
            int retryAfter = 1;

            if ((oldest != null && !oldest.isEmpty())) {
                Double oldestScore = oldest.iterator().next().getScore();
                if (oldestScore != null) {

                    // 8. calculate when the request leaves the window
                    long windowExpiresMs = oldestScore.longValue() + windowSeconds * 1000;
                    retryAfter = (int) Math.ceil((windowExpiresMs - nowMs) / 1000.0);
                }
            }
            return RateLimitResult.denied(retryAfter);
        }

        // 9. if the limit hasn't been reached
        zset.add(redisKey, UUID.randomUUID().toString(), nowMs);

        // 10. set redis expiration (the '+1' is simply for a small safety/cleanup buffer)
        redis.expire(redisKey, Duration.ofSeconds(windowSeconds + 1));

        // 11. calculate remaining requests
        return RateLimitResult.allowed((int) (maxRequestAllowed - current - 1));
    }
}
