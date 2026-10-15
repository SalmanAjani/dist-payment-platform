package com.salman98.razorpay_dist.payment_service.gateway;


import com.salman98.razorpay_dist.payment_service.gateway.dto.PaymentRequest;
import com.salman98.razorpay_dist.payment_service.gateway.dto.PaymentResult;

import java.util.UUID;

public interface PaymentAdapter {

    PaymentResult initiate(PaymentRequest request);

    PaymentResult capture(UUID paymentId);
}
