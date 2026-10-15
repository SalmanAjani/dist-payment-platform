package com.salman98.razorpay_dist.common_lib.context;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MerchantContext {

    private UUID merchantId;
    private String keyId;
}
