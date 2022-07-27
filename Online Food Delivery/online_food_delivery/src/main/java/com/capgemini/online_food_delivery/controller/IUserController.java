package com.capgemini.online_food_delivery.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

import com.capgemini.online_food_delivery.entity.User;
import com.capgemini.online_food_delivery.exception.UserAlreadyExistException;
import com.capgemini.online_food_delivery.service.IUserService;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/User")
public class IUserController {



    @Autowired
    IUserService userService;


    @PostMapping("/signUp")
    public ResponseEntity<User> signUp(@RequestBody User user, HttpSession session) throws UserAlreadyExistException {
        User user1 = userService.userSignUp(user);
        if (user1 != null) {
            session.setAttribute("user", user1);
            return new ResponseEntity<User>(user1, HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(user1, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user, HttpSession session) {
        User user_info = userService.userSignIn(user);
        if (user_info != null) {
            session.setAttribute("user", user_info);
            return new ResponseEntity<>(user_info, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        if (session.getAttribute("user") != null) {
            session.invalidate();
            return new ResponseEntity<>("Logout Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("You are not logged in", HttpStatus.BAD_REQUEST);
        }
    }
    
}
