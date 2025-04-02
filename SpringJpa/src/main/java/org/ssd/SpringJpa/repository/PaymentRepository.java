package org.ssd.SpringJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssd.SpringJpa.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
