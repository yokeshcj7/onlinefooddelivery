package com.capgemini.online_food_delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.online_food_delivery.dto.CartAddDto;
import com.capgemini.online_food_delivery.dto.CartDto;
import com.capgemini.online_food_delivery.exception.CartNotFoundException;
import com.capgemini.online_food_delivery.service.IFoodCartServiceImpl;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/FoodCart")
public class IFoodCartController {

    @Autowired
    private IFoodCartServiceImpl foodCartService;

    /**
     * @Method: addItemToFoodCart
     * @Description: This method is used to add an item to the food cart.
     * @param foodCart
     * @return FoodCart return the foodCart
     */
    @PostMapping("/addItemToFoodCart")
    public ResponseEntity<CartDto> addItemToFoodCart(@RequestBody CartAddDto cart) {

        return new ResponseEntity<CartDto>(foodCartService.addItemToFoodCart(cart), HttpStatus.OK);
    }

    /**
     * @Method: increaseQuantity
     * @Description: This method is used to increase the quantity of the item in the food cart.
     * @param customerId
     * @param restaurentItemId
     * @return FoodCart return the foodCart
     * @throws CartNotFoundException
     */
    @PutMapping("/increaseQuantity/{customerId}/{restaurentItemId}")
    public ResponseEntity<CartDto> increaseQuantity(@PathVariable int customerId, @PathVariable int restaurentItemId) throws CartNotFoundException {

        return new ResponseEntity<CartDto>(foodCartService.increaseQuantity(customerId, restaurentItemId), HttpStatus.OK);
    }

    /**
     * @Method: reduceQuantity
     * @Description: This method is used to reduce the quantity of the item in the food cart.
     * @param customerId
     * @param restaurentItemId
     * @return FoodCart return the foodCart
     * @throws CartNotFoundException
     */
    @PutMapping("/reduceQuantity/{customerId}/{restaurentItemId}")
    public ResponseEntity<CartDto> reduceQuantity(@PathVariable("customerId") int customerId,
            @PathVariable("restaurentItemId") int restaurentItemId) throws CartNotFoundException {

        return new ResponseEntity<CartDto>(foodCartService.reduceQuantity(customerId, restaurentItemId), HttpStatus.OK);
    }

    /**
     * @Method: getFoodCart
     * @Description: This method is used to get the food cart of the user.
     * @param customerId
     * @return FoodCart return the foodCart
     * @throws CartNotFoundException
     */
    @GetMapping("/getFoodCart/{customerId}")
    public ResponseEntity<CartDto> getFoodCart(@PathVariable int customerId) throws CartNotFoundException {

        return new ResponseEntity<CartDto>(foodCartService.getFoodCart(customerId), HttpStatus.OK);
    }

    /**
     * @Method: clearFoodCart
     * @Description: This method is used to clear the food cart of the user.
     * @param customerId
     * @return String return the message
     * @throws CartNotFoundException
     */
    @GetMapping("/clearFoodCart/{customerId}")
    public ResponseEntity<String> clearFoodCart(@PathVariable int customerId) throws CartNotFoundException {

        return new ResponseEntity<String>(foodCartService.clearFoodCart(customerId), HttpStatus.OK);
    }

    /**
     * @Method: deleteItemFromFoodCart
        * @Description: This method is used to delete an item from the food cart
        * @param customerId
        * @param restaurentItemId
        * @return String
        * @throws CartNotFoundException
     */
    @DeleteMapping("/deleteItemFromFoodCart/{customerId}/{restaurentItemId}")
    public ResponseEntity<String> deleteItemFromFoodCart(@PathVariable int customerId, @PathVariable int restaurentItemId) throws CartNotFoundException {

        return new ResponseEntity<String>(foodCartService.deleteItemFromFoodCart(customerId, restaurentItemId), HttpStatus.OK);
    }

}
