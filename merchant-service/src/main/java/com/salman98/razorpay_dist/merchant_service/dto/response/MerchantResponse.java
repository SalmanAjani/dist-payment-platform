package com.salman98.razorpay_dist.merchant_service.dto.response;


import com.salman98.razorpay_dist.common_lib.enums.BusinessType;
import com.salman98.razorpay_dist.common_lib.enums.MerchantStatus;

import java.util.UUID;

public record MerchantResponse(
        UUID id,
        String name,
        String email,
        String businessName,
        BusinessType businessType,
        MerchantStatus merchantStatus
) {
}
