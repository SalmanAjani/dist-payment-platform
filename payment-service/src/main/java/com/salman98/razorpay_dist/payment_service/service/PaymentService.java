package com.salman98.razorpay_dist.payment_service.service;


import com.salman98.razorpay_dist.payment_service.dto.request.PaymentInitRequest;
import com.salman98.razorpay_dist.payment_service.dto.response.PaymentResponse;

import java.util.UUID;

public interface PaymentService {
    PaymentResponse initiate(UUID merchantId, PaymentInitRequest request);

    PaymentResponse capture(UUID merchantId, UUID paymentId);

    void resolveAuthorization(UUID paymentId, boolean approve, String bankRef, String errorCode, String errorDescription);
}
