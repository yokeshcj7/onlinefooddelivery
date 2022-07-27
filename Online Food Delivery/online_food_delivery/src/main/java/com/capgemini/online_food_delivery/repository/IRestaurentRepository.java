package com.capgemini.online_food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.online_food_delivery.entity.Restaurent;

@Repository
public interface IRestaurentRepository extends JpaRepository<Restaurent, Integer> {

    public Restaurent getRestaurentById(int restaurentId);

}
