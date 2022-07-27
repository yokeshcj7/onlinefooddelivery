package com.capgemini.online_food_delivery.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**********************************************************************************************
 * - @author Shashank Mathur
 * - @Description: This is a Category Entity class which is mapped to the
 * database table
 * Category.
 * - @since: 13-07-2022
 * - @version: 1.0
 * - @Last modified by: Shashank Mathur
 * 
 **********************************************************************************************/

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private int id;
    private String name;
    // private List<Item> itemList;

    public Category() {
        // TODO Auto-generated constructor stub
    }

    public Category(String name) {
        this.name = name;
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


}
