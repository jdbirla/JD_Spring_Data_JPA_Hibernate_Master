package com.jd.spring.data.jpa.repository;

import com.jd.spring.data.jpa.entity.Address;
import com.jd.spring.data.jpa.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * Created by jd birla on 02-12-2022 at 08:18
 */
@SpringBootTest
public class OneToOneUniDirectionalMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrder() {
        Order order = new Order();
        order.setOrderTrackingNumber("0001");
        order.setTotalPrice(new BigDecimal(100));
        order.setTotalQuantity(5);
        order.setStatus("DISPATCH");

        Address address = new Address();
        address.setCity("Indore");
        address.setStreet("Shankheshwar city");
        address.setState("M.P.");
        address.setCountry("India");
        address.setZipCode("453555");

        order.setBillingAddress(address);

        orderRepository.save(order);

    }

    @Test
    void updateOrder() {
        Order order = orderRepository.findById(1L).get();
        order.setStatus("DELIVERED");
        order.getBillingAddress().setStreet("Near Premium Park");

        orderRepository.save(order);
    }

    @Test
    void deleteOrder() {
        orderRepository.deleteById(1L);
    }

    @Test
    void getOrder() {
        Order order = orderRepository.findById(2L).get();
        System.out.println(order.toString());
    }


}
