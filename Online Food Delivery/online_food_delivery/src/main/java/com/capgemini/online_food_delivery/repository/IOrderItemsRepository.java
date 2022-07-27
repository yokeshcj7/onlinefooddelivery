package com.capgemini.online_food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.online_food_delivery.entity.OrderItems;
import java.util.List;

@Repository
public interface IOrderItemsRepository extends JpaRepository<OrderItems, Integer> {


    public List<OrderItems> findByOrderId(int orderId);

}
