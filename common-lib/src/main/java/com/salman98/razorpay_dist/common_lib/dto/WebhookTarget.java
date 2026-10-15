package com.salman98.razorpay_dist.common_lib.dto;

import java.util.UUID;

public record WebhookTarget(
        UUID configId, String targetUrl, String webhookSecret
) {
}
