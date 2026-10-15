package com.salman98.razorpay_dist.operations_service.repository;

import com.salman98.razorpay_dist.common_lib.enums.WebhookEventStatus;
import com.salman98.razorpay_dist.operations_service.entity.WebhookEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface WebhookEventRepository extends JpaRepository<WebhookEvent, UUID> {
    List<WebhookEvent> findByStatusAndNextRetryAtBefore(WebhookEventStatus webhookEventStatus, LocalDateTime now);
}