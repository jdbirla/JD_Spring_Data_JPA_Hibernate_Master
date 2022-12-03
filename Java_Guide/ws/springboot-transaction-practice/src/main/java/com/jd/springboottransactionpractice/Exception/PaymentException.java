package com.jd.springboottransactionpractice.Exception;

/**
 * Created by jd birla on 02-12-2022 at 18:54
 */
public class PaymentException extends RuntimeException{
    public PaymentException(String message)
    {
        super(message);
    }

}
