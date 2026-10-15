package com.salman98.razorpay_dist.common_lib.dto;

import java.util.UUID;

public record PaymentSettlementView(
        UUID paymentId,
        int amountUnits,
        int refundedAmountUnits,
        String currency
) {
}
