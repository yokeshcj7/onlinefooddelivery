package com.capgemini.online_food_delivery.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**********************************************************************************************
 * - @author Shashank Mathur
 * - @Description: This is a Bill Entity class which is mapped to the
 * database table
 * Bill.
 * - @since: 13-07-2022
 * - @version: 1.0
 * - @Last modified by: Shashank Mathur
 * 
 **********************************************************************************************/

@Entity
@Table(name = "Bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bill_id")
    private int id;
    private LocalDateTime billDate;
    private double totalCost;
    private int totalItem;
    private int orderId;
    private int customerId;

    public Bill() {
        // TODO Auto-generated constructor stub
    }

    public Bill(LocalDateTime billDate, double totalCost, int totalItem, int orderId, int customerId) {
        super();
        this.billDate = billDate;
        this.totalCost = totalCost;
        this.totalItem = totalItem;
        this.orderId = orderId;
        this.customerId = customerId;
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
     * @return LocalDateTime return the billDate
     */
    public LocalDateTime getBillDate() {
        return billDate;
    }

    /**
     * @param billDate the billDate to set
     */
    public void setBillDate(LocalDateTime billDate) {
        this.billDate = billDate;
    }

    /**
     * @return double return the totalCost
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * @param totalCost the totalCost to set
     */
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * @return int return the totalItem
     */
    public int getTotalItem() {
        return totalItem;
    }

    /**
     * @param totalItem the totalItem to set
     */
    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
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

}