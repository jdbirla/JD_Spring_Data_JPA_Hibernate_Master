package com.jd.spring.data.jpa.repository;

import com.jd.spring.data.jpa.entity.Address;
import com.jd.spring.data.jpa.entity.Order;
import com.jd.spring.data.jpa.entity.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * Created by jd birla on 02-12-2022 at 10:17
 */
@SpringBootTest
public class OneToManyMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveOrderWithOrderItems() {
        Order order = new Order();
        order.setOrderTrackingNumber("00014");
        order.setStatus("DISPATCH");

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProduct(productRepository.findById(1L).get());
        orderItem1.setQuantity(5);
        orderItem1.setPrice(orderItem1.getProduct().getPrice().multiply(BigDecimal.valueOf(orderItem1.getQuantity())));
        orderItem1.setImageUrl("img1.png");
        order.getOrderItemSets().add(orderItem1);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(productRepository.findById(2L).get());
        orderItem2.setQuantity(5);
        orderItem2.setPrice(orderItem2.getProduct().getPrice().multiply(BigDecimal.valueOf(orderItem2.getQuantity())));
        orderItem2.setImageUrl("img2.png");
        order.getOrderItemSets().add(orderItem2);

        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(2);

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
    void fetchOrders() {
        Order order = orderRepository.findById(1L).get();
        System.out.println(order.toString());


    }

    @Test
    void deleteOrder() {
        orderRepository.deleteById(1L);


    }
}
