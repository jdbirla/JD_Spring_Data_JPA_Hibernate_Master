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
public class OneToOneBiDirectionalMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;
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
        address.setOrder(order);
        addressRepository.save(address);

    }

    @Test
    void updateAddress() {


        Address address = addressRepository.findById(1L).get();
        address.setCountry("USA");

        address.getOrder().setStatus("RETURNED");
        addressRepository.save(address);
    }


    @Test
    void deleteAddress() {
        addressRepository.deleteById(1L);
    }

    @Test
    void getAddress() {
        Address address = addressRepository.findById(1L).get();
        System.out.println(address.toString());
    }


}
