package com.salman98.razorpay_dist.payment_service.gateway.dto;


import com.salman98.razorpay_dist.common_lib.entity.Money;
import com.salman98.razorpay_dist.common_lib.enums.PaymentMethod;

import java.util.Map;
import java.util.UUID;

public record PaymentRequest(
        UUID paymentId,
        UUID orderId,
        UUID merchantId,
        Money amount,
        PaymentMethod method,
        Map<String, Object> methodDetails
) {
}
