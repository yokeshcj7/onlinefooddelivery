package com.capgemini.online_food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.online_food_delivery.entity.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
