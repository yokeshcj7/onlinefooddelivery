package com.capgemini.online_food_delivery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**********************************************************************************************
 * - @author Shashank Mathur
 * - @Description: This is a Address Entity class which is mapped to the
 * database table
 * Address.
 * - @since: 13-07-2022
 * - @version: 1.0
 * - @Last modified by: Shashank Mathur
 * 
 **********************************************************************************************/

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int id;
    private String buildingName;
    private String streetNo;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private int userId;

    public Address() {
        // TODO Auto-generated constructor stub
    }

    public Address(String buildingName, String streetNo, String city, String state, String country, String pincode,
            int userId) {

        /*
         * @param buildingName: Address's Building name
         * 
         * @param streetNo: Address's Street No
         * 
         * @param city: Address's City
         * 
         * @param state: Address's State
         * 
         * @param country: Address's Country
         * 
         * @param pincode: Address's Pincode
         * 
         */

        this.buildingName = buildingName;
        this.streetNo = streetNo;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.userId = userId;
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
     * @return String return the buildingName
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * @param buildingName the buildingName to set
     */
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    /**
     * @return String return the streetNo
     */
    public String getStreetNo() {
        return streetNo;
    }

    /**
     * @param streetNo the streetNo to set
     */
    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    /**
     * @return String return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return String return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return String return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return String return the pincode
     */
    public String getPincode() {
        return pincode;
    }

    /**
     * @param pincode the pincode to set
     */
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    /**
     * @return int return the userId
     */
    public int getuserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setuserId(int userId) {
        this.userId = userId;
    }

}
