package com.salman98.razorpay_dist.merchant_service.dto.response;


import com.salman98.razorpay_dist.common_lib.enums.Environment;

import java.util.UUID;

public record ApiKeyCreateResponse(
        UUID id,
        String keyId,
        String keySecret,
        Environment environment
) {
}
