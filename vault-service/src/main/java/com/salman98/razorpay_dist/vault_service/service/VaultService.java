package com.salman98.razorpay_dist.vault_service.service;

import com.salman98.razorpay_dist.common_lib.dto.PaymentProcessorResponse;
import com.salman98.razorpay_dist.common_lib.entity.Money;
import com.salman98.razorpay_dist.vault_service.dto.request.TokenizeRequest;
import com.salman98.razorpay_dist.vault_service.dto.response.TokenizeResponse;

import java.util.Map;
import java.util.UUID;

public interface VaultService {
    TokenizeResponse tokenize(TokenizeRequest request, UUID merchantId);

    PaymentProcessorResponse charge(UUID paymentId, String token, Money amount, Map<String, Object> methodDetails);
}
