package com.jd.springboottransactionpractice.services;

import com.jd.springboottransactionpractice.dto.OrderRequest;
import com.jd.springboottransactionpractice.dto.OrderResponse;

/**
 * Created by jd birla on 02-12-2022 at 18:49
 */
public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
