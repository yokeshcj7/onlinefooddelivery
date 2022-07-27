package com.capgemini.online_food_delivery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FoodCartItems")
public class FoodCartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "foodcartitem_id")
    private Integer id;
    private Integer cartId;
    private Integer restItemId;
    private Integer quantity;
    private double totalAmount;

    public FoodCartItems() {
        // TODO Auto-generated constructor stub
    }

    public FoodCartItems(Integer id, Integer cartId, Integer restItemId, Integer quantity, double totalAmount) {
        this.id = id;
        this.cartId = cartId;
        this.restItemId = restItemId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return Integer return the cartId
     */
    public Integer getCartId() {
        return cartId;
    }

    /**
     * @param cartId the cartId to set
     */
    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    /**
     * @return Integer return the restItemId
     */
    public Integer getRestItemId() {
        return restItemId;
    }

    /**
     * @param restItemId the restItemId to set
     */
    public void setRestItemId(Integer restItemId) {
        this.restItemId = restItemId;
    }

    /**
     * @return Integer return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return Integer return the totalAmount
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
