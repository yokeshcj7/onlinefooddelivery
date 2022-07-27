package com.capgemini.online_food_delivery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**********************************************************************************************
 * - @author Shashank Mathur
 * - @Description: This is a Users Entity class which is mapped to the
 * database table
 * Users.
 * - @since: 13-07-2022
 * - @version: 1.0
 * - @Last modified by: Shashank Mathur
 * 
 **********************************************************************************************/

@Entity
@Table(name = "FoodCart")
public class FoodCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "foodcart_id")
    private int id;
    private int customerId;
    private double cartTotal;

    public FoodCart() {
        // TODO Auto-generated constructor stub
    }

    public FoodCart(int customerId, double cartTotal) {
        this.customerId = customerId;
        this.cartTotal = cartTotal;
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
     * @return int return the customerId
     */
    public int getcustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setcustomerId(int customerId) {
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

}