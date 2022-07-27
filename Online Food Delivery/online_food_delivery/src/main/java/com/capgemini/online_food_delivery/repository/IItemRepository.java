package com.capgemini.online_food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.online_food_delivery.entity.Item;

import java.util.List;

@Repository
public interface IItemRepository extends JpaRepository<Item, Integer> {

    public Item getItemById(int id);

    public List<Item> getItemByCategoryId(int categoryId);

}
