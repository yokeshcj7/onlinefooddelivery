package com.capgemini.online_food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.online_food_delivery.entity.OrderDetails;
import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {

    public List<OrderDetails> findByCustomerId(int customerId);


}
