package com.salman98.razorpay_dist.merchant_service.service;


import com.salman98.razorpay_dist.merchant_service.dto.request.LoginRequest;
import com.salman98.razorpay_dist.merchant_service.dto.request.MerchantSignupRequest;
import com.salman98.razorpay_dist.merchant_service.dto.response.LoginResponse;
import com.salman98.razorpay_dist.merchant_service.dto.response.MerchantResponse;

public interface AuthService {
    MerchantResponse signup(MerchantSignupRequest request);

    LoginResponse login(LoginRequest request);
}
