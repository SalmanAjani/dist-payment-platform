package com.salman98.razorpay_dist.merchant_service.dto.request;


import com.salman98.razorpay_dist.common_lib.enums.Environment;

public record CreateApiKeyRequest(
        Environment environment
) {
}
