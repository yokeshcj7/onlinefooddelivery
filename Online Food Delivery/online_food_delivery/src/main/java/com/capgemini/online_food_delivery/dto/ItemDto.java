package com.capgemini.online_food_delivery.dto;

public class ItemDto {

    private String name;
    private int categoryId;
    private int restaurentId;
    private double cost;

    public ItemDto() {
    }

    public ItemDto(String name, int categoryId, int restaurentId, double cost) {
        this.name = name;
        this.categoryId = categoryId;
        this.restaurentId = restaurentId;
        this.cost = cost;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return int return the restaurentId
     */
    public int getRestaurentId() {
        return restaurentId;
    }

    /**
     * @param restaurentId the restaurentId to set
     */
    public void setRestaurentId(int restaurentId) {
        this.restaurentId = restaurentId;
    }

    /**
     * @return double return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ItemDao [name=" + name + ", categoryId=" + categoryId + ", restaurentId=" + restaurentId + ", cost="
                + cost + "]";
    }

}
