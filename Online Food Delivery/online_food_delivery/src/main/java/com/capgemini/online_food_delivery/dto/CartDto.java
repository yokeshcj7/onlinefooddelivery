package com.capgemini.online_food_delivery.dto;

import com.capgemini.online_food_delivery.entity.FoodCartItems;

import java.util.List;

public class CartDto {

    private int customerId;
    private double cartTotal;
    private List<FoodCartItems> foodCartItems;

    public CartDto() {
        // TODO Auto-generated constructor stub
    }

    public CartDto(int customerId, double cartTotal, List<FoodCartItems> foodCartItems) {
        this.customerId = customerId;
        this.cartTotal = cartTotal;
        this.foodCartItems = foodCartItems;
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
     * @return double return the cartTotal
     */
    public double getCartTotal() {
        return cartTotal;
    }

    /**
     * @param cartTotal the cartTotal to set
     */
    public void setCartTotal(double cartTotal) {
        this.cartTotal = cartTotal;
    }

    /**
     * @return List<FoodCartItems> return the foodCartItems
     */
    public List<FoodCartItems> getFoodCartItems() {
        return foodCartItems;
    }

    /**
     * @param foodCartItems the foodCartItems to set
     */
    public void setFoodCartItems(List<FoodCartItems> foodCartItems) {
        this.foodCartItems = foodCartItems;
    }

}
