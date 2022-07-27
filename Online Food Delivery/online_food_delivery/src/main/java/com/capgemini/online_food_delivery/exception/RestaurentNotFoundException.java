package com.capgemini.online_food_delivery.exception;

public class RestaurentNotFoundException extends RuntimeException {
    public RestaurentNotFoundException(String msg) {
        super(msg);
    }
}