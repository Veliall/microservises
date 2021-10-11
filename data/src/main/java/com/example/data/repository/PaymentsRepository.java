package com.example.data.repository;

import com.example.data.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<PaymentEntity, Long> {
}
