package com.capgemini.online_food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.online_food_delivery.entity.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findCustomerById(Integer id);

    Customer findCustomerByUserId(Integer id);

}
    
