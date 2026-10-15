package com.salman98.razorpay_dist.merchant_service.service.impl;

import com.salman98.razorpay_dist.common_lib.dto.SettlementBankDetails;
import com.salman98.razorpay_dist.common_lib.dto.WebhookTarget;
import com.salman98.razorpay_dist.common_lib.enums.MerchantStatus;
import com.salman98.razorpay_dist.common_lib.exception.ResourceNotFoundException;
import com.salman98.razorpay_dist.merchant_service.api.MerchantLookupService;
import com.salman98.razorpay_dist.merchant_service.entity.Merchant;
import com.salman98.razorpay_dist.merchant_service.repository.MerchantRepository;
import com.salman98.razorpay_dist.merchant_service.repository.WebhookConfigRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class MerchantLookupServiceImpl implements MerchantLookupService {

    private final MerchantRepository merchantRepository;
    private final WebhookConfigRepository merchantWebhookConfigRepository;
    private final BytesEncryptor bytesEncryptor;

    @Override
    public List<WebhookTarget> getActiveConfigsForEvent(UUID merchantId, String eventType) {

        // finding target URL for given eventType
        return merchantWebhookConfigRepository
                .findByMerchant_IdAndEnabledTrue(merchantId)
                .stream()
                .filter(config -> config.isSubscribedTo(eventType))
                .map(config -> {
                    byte[] encryptedSecretBytes = Base64.getDecoder()
                            .decode(config.getWebhookSecret());

                    byte[] decryptedSecretBytes = bytesEncryptor
                            .decrypt(encryptedSecretBytes);

                    String decryptedSecret = new String(
                            decryptedSecretBytes,
                            StandardCharsets.UTF_8
                    );

                    return new WebhookTarget(
                            config.getId(),
                            config.getTargetUrl(),
                            decryptedSecret
                    );
                })
                .toList();
    }

    @Override
    public List<UUID> listActiveMerchantIds() {
        return merchantRepository.findByStatus(MerchantStatus.ACTIVE)
                .stream().map(m -> m.getId()).toList();
    }

    @Override
    public SettlementBankDetails getSettlementBankDetails(UUID merchantId) {
        Merchant merchant = merchantRepository.findById(merchantId).orElseThrow(
                () -> new ResourceNotFoundException("Merchant", merchantId));

        return new SettlementBankDetails(
                merchant.getSettlementBankAccount(),
                merchant.getSettlementBankIfsc(),
                merchant.getSettlementBankAccountHolderName()
        );
    }
}
