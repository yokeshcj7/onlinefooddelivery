package com.capgemini.online_food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.online_food_delivery.entity.FoodCartItems;

import java.util.List;

@Repository
public interface IFoodCartItemsRepository extends JpaRepository<FoodCartItems, Integer> {

    public List<FoodCartItems> findByCartId(int cartId);

    public FoodCartItems findByCartIdAndRestItemId(int cartId, int restItemId);

}