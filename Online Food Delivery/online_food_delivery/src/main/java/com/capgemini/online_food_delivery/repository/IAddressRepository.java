package com.capgemini.online_food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.online_food_delivery.entity.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {

    Address findAddressById(Integer id);


}
