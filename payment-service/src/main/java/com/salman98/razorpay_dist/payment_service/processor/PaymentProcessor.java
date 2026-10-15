package com.salman98.razorpay_dist.payment_service.processor;


import com.salman98.razorpay_dist.common_lib.dto.PaymentProcessorRequest;
import com.salman98.razorpay_dist.common_lib.dto.PaymentProcessorResponse;

public interface PaymentProcessor {

    PaymentProcessorResponse charge(PaymentProcessorRequest request);
}
