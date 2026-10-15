package com.salman98.razorpay_dist.operations_service.settlement;


import com.salman98.razorpay_dist.common_lib.entity.Money;
import com.salman98.razorpay_dist.operations_service.settlement.dto.BankTransferResult;

import java.util.UUID;

public interface BankTransferProcessor {
    
    BankTransferResult initiate(UUID settlementId, UUID merchantId, Money amount,
                                String bankAccount, String ifsc);
}
