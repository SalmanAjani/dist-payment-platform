package com.salman98.razorpay_dist.merchant_service.mapper;

import com.salman98.razorpay_dist.merchant_service.dto.response.ApiKeyCreateResponse;
import com.salman98.razorpay_dist.merchant_service.dto.response.ApiKeyResponse;
import com.salman98.razorpay_dist.merchant_service.entity.ApiKey;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApiKeyMapper {

    ApiKeyCreateResponse toCreateResponse(ApiKey apiKey);

    List<ApiKeyResponse> toResponseList(List<ApiKey> apiKeyList);
}
