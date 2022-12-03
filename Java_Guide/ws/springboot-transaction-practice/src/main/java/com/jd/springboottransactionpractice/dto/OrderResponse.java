package com.jd.springboottransactionpractice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by jd birla on 02-12-2022 at 18:47
 */
@Getter
@Setter
public class OrderResponse {
    private String orderTrackingNumber;
    private String status;
    private String message;
}
