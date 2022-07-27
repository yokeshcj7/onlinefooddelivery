package com.capgemini.online_food_delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.online_food_delivery.entity.Bill;


@Repository
public interface IBillRepository extends JpaRepository<Bill, Integer> {


    Bill findBillById(int billId);

    List<Bill> findBillsByCustomerId(int customerId);

}
