package com.capgemini.online_food_delivery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderItems")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderitem_id")
    private int id;
    private int orderId;
    private int restaurentId;
    private int itemId;
    private int quantity;
    private double ammount;

    public OrderItems() {
        // TODO Auto-generated constructor stub
    }

    public OrderItems(int id, int orderId, int restaurentId, int itemId, int quantity, double ammount) {
        this.id = id;
        this.orderId = orderId;
        this.restaurentId = restaurentId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.ammount = ammount;
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
     * @return int return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    /**
     * @return int return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return double return the ammount
     */
    public double getAmmount() {
        return ammount;
    }

    /**
     * @param ammount the ammount to set
     */
    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

}
