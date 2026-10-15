package com.salman98.razorpay_dist.merchant_service.service;


import com.salman98.razorpay_dist.merchant_service.dto.request.UpdateWebhookConfigRequest;
import com.salman98.razorpay_dist.merchant_service.dto.response.WebhookConfigResponse;

import java.util.List;
import java.util.UUID;

public interface WebhookConfigService {

    WebhookConfigResponse create(UUID merchantId, UpdateWebhookConfigRequest request);

    List<WebhookConfigResponse> list(UUID merchantId);

    WebhookConfigResponse getById(UUID merchantId, UUID configId);

    WebhookConfigResponse update(UUID merchantId, UUID configId, UpdateWebhookConfigRequest request);

    void delete(UUID merchantId, UUID configId);
}
