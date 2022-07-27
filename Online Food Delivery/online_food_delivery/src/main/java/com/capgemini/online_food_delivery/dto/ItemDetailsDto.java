package com.capgemini.online_food_delivery.dto;

public class ItemDetailsDto {

    private String itemName;
    private String category;
    private String restaurentName;

    /**
     * @return String return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return String return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return String return the restaurentName
     */
    public String getRestaurentName() {
        return restaurentName;
    }

    /**
     * @param restaurentName the restaurentName to set
     */
    public void setRestaurentName(String restaurentName) {
        this.restaurentName = restaurentName;
    }

}
