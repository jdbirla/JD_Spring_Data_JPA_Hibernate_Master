package com.jd.spring.data.jpa.repository;

import com.jd.spring.data.jpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jd birla on 02-12-2022 at 08:02
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByOrderTrackingNumber(String name);


}
