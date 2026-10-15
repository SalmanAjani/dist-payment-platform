package com.salman98.razorpay_dist.vault_service.dto.response;


import com.salman98.razorpay_dist.common_lib.enums.CardBrand;

public record TokenizeResponse(
        String token,
        String lastFour,
        CardBrand brand,
        Integer expiryMonth,
        Integer expiryYear
) {
}
