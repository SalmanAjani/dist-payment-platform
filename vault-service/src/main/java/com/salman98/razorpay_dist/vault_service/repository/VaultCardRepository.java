package com.salman98.razorpay_dist.vault_service.repository;

import com.salman98.razorpay_dist.vault_service.entity.VaultCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VaultCardRepository extends JpaRepository<VaultCard, UUID> {
}