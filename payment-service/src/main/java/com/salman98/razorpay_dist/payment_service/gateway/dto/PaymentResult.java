package com.salman98.razorpay_dist.payment_service.gateway.dto;

public sealed interface PaymentResult permits PaymentResult.Pending, PaymentResult.Failure, PaymentResult.Success {

    record Pending(String registrationRef) implements PaymentResult {
    }

    record Failure(String errorCode, String errorDescription) implements PaymentResult {
    }

    record Success(String bankReference) implements PaymentResult {
    }
}
