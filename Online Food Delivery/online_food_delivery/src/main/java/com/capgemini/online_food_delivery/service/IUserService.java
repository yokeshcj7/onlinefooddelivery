package com.capgemini.online_food_delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capgemini.online_food_delivery.entity.User;
import com.capgemini.online_food_delivery.exception.UserAlreadyExistException;
import com.capgemini.online_food_delivery.exception.WrongPasswordException;
import com.capgemini.online_food_delivery.repository.IUserRepository;
import com.capgemini.online_food_delivery.repository.ICustomerRepository;

@Service
@Transactional
public class IUserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    ICustomerRepository customerRepository;

    public User userSignUp(User user) throws UserAlreadyExistException {
        User user1 = userRepository.findByUserName(user.getUserName());
        if (user1 != null) {
            throw new UserAlreadyExistException("UserName already exist");
        } else {
            userRepository.save(user);
            return user;
        }
    }

    public User userSignIn(User user) throws WrongPasswordException {
        User user1 = userRepository.findByUserName(user.getUserName());
        if (user.getPassword().equals(user1.getPassword())) {
            return user1;
        } else {
            throw new WrongPasswordException("Wrong Password");
        }
    }

}
