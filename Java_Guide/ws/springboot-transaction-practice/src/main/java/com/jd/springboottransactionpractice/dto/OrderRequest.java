package com.jd.springboottransactionpractice.dto;

import com.jd.springboottransactionpractice.entity.Order;
import com.jd.springboottransactionpractice.entity.Payment;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by jd birla on 02-12-2022 at 18:46
 */
@Getter
@Setter
public class OrderRequest {

    private Order order;
    private Payment payment;
}
