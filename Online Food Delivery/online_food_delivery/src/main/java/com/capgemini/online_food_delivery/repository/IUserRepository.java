package com.capgemini.online_food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.online_food_delivery.entity.User;


@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

    User findUserById(Integer id);


}
    

