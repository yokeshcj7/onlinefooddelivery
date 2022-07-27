package com.capgemini.online_food_delivery.dto;

import com.capgemini.online_food_delivery.entity.OrderItems;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDetailsDto {

    private int id;
    private LocalDateTime orderDate;
    private int customerId;
    private String status;
    private double orderAmount;

    private List<OrderItems> orderItems;

    public OrderDetailsDto() {
    }

    public OrderDetailsDto(int id, LocalDateTime orderDate, int customerId, String status, double orderAmount,
            List<OrderItems> orderItems) {
        this.id = id;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.status = status;
        this.orderAmount = orderAmount;
        this.orderItems = orderItems;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return LocalDateTime return the orderDate
     */
    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return int return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return double return the orderAmount
     */
    public double getOrderAmount() {
        return orderAmount;
    }

    /**
     * @param orderAmount the orderAmount to set
     */
    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * @return List<OrderItems> return the orderItems
     */
    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    /**
     * @param orderItems the orderItems to set
     */
    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

}
