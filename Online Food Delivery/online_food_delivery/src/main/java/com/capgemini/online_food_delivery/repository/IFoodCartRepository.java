package com.capgemini.online_food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.online_food_delivery.entity.FoodCart;

/**********************************************************************************************
 * - @author Shashank Mathur
 * - @Description: This is a FoodCart Repository class which is mapped to the
 * database table
 * - @since: 13-07-2022
 * 
 **********************************************************************************************/

@Repository
public interface IFoodCartRepository extends JpaRepository<FoodCart, Integer> {

    public FoodCart findByCustomerId(int customerId);
    

}
