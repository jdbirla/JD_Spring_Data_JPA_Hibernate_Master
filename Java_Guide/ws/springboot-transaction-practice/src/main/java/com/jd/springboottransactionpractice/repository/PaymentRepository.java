package com.jd.springboottransactionpractice.repository;

import com.jd.springboottransactionpractice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jd birla on 02-12-2022 at 18:45
 */
public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
