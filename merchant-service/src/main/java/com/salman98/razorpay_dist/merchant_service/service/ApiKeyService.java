package com.salman98.razorpay_dist.merchant_service.service;

import com.salman98.razorpay_dist.merchant_service.dto.request.CreateApiKeyRequest;
import com.salman98.razorpay_dist.merchant_service.dto.response.ApiKeyCreateResponse;
import com.salman98.razorpay_dist.merchant_service.dto.response.ApiKeyResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public interface ApiKeyService {
    ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request);

    List<ApiKeyResponse> listByMerchant(UUID merchantId);

    void revoke(UUID merchantId, UUID keyId);

    @Nullable
    ApiKeyCreateResponse rotate(UUID merchantId, UUID keyId);
}