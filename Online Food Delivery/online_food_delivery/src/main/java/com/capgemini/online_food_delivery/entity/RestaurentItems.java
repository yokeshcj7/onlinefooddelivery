package com.capgemini.online_food_delivery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RestaurentItems")
public class RestaurentItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restitemId")
    private int id;
    private int restId;
    private int itemId;
    private double cost;

    public RestaurentItems() {
        // TODO Auto-generated constructor stub
    }

    public RestaurentItems(int restId, int itemId, double cost) {
        this.restId = restId;
        this.itemId = itemId;
        this.cost = cost;
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
     * @return int return the restId
     */
    public int getrestId() {
        return restId;
    }

    /**
     * @param restId the restId to set
     */
    public void setrestId(int restId) {
        this.restId = restId;
    }

    /**
     * @return int return the itemId
     */
    public int getitemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setitemId(int itemId) {
        this.itemId = itemId;
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

    public Object thenReturn(RestaurentItems restaurentItems) {
        return null;
    }

}
