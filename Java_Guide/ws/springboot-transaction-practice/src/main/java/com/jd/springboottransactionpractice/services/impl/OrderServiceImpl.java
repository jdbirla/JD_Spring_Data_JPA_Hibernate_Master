package com.jd.springboottransactionpractice.services.impl;

import com.jd.springboottransactionpractice.Exception.PaymentException;
import com.jd.springboottransactionpractice.dto.OrderRequest;
import com.jd.springboottransactionpractice.dto.OrderResponse;
import com.jd.springboottransactionpractice.entity.Order;
import com.jd.springboottransactionpractice.entity.Payment;
import com.jd.springboottransactionpractice.repository.OrderRepository;
import com.jd.springboottransactionpractice.repository.PaymentRepository;
import com.jd.springboottransactionpractice.services.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by jd birla on 02-12-2022 at 18:50
 */
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("inProgress");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();
        if (!payment.getCardType().equals("DEBIT")) {
            throw new PaymentException("Payment card type not supported");

        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
