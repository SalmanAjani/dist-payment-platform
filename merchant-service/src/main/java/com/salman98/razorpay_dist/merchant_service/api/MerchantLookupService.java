package com.salman98.razorpay_dist.merchant_service.api;

import com.salman98.razorpay_dist.common_lib.dto.SettlementBankDetails;
import com.salman98.razorpay_dist.common_lib.dto.WebhookTarget;

import java.util.List;
import java.util.UUID;

public interface MerchantLookupService {

    // Method to know how many URLs a merchant has configured for a particular event type
    List<WebhookTarget> getActiveConfigsForEvent(UUID merchantId, String eventType);

    List<UUID> listActiveMerchantIds();

    SettlementBankDetails getSettlementBankDetails(UUID merchantId);

}
