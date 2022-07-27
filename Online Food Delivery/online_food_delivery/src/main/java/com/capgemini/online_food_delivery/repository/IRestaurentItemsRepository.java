package com.capgemini.online_food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.online_food_delivery.entity.RestaurentItems;

import java.util.List;

@Repository
public interface IRestaurentItemsRepository extends JpaRepository<RestaurentItems, Integer> {

    public RestaurentItems findByitemId(int itemId);

    public List<RestaurentItems> findByRestId(int restId);

    public RestaurentItems findByItemId(int itemId);
}
