package com.capgemini.online_food_delivery.dto;

public class CartAddDto {

    private int customerId;
    private int itemId;

    public CartAddDto() {
    }

    public CartAddDto(int customerId, int itemId) {
        this.customerId = customerId;
        this.itemId = itemId;
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
     * @return int return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

}
