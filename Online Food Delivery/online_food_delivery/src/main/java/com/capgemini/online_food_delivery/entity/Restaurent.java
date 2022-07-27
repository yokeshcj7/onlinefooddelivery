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
@Table(name = "Restaurent")
public class Restaurent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurent_id")
    private int id;
    private String restaurentName;
    private String restaurentAddress;
    private String managerName;
    private String contactNumber;

    public Restaurent() {
        // TODO Auto-generated constructor stub
    }

    public Restaurent(String restaurentName, String restaurentAddress, String managerName, String contactNumber) {
        this.restaurentName = restaurentName;
        this.restaurentAddress = restaurentAddress;
        this.managerName = managerName;
        this.contactNumber = contactNumber;
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

    /**
     * @return String return the restaurentAddress
     */
    public String getRestaurentAddress() {
        return restaurentAddress;
    }

    /**
     * @param restaurentAddress the restaurentAddress to set
     */
    public void setRestaurentAddress(String restaurentAddress) {
        this.restaurentAddress = restaurentAddress;
    }

    /**
     * @return String return the managerName
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * @param managerName the managerName to set
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    /**
     * @return String return the contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

}
