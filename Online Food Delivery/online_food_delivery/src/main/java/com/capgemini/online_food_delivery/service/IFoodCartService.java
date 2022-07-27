package com.capgemini.online_food_delivery.service;

import com.capgemini.online_food_delivery.dto.CartAddDto;
import com.capgemini.online_food_delivery.dto.CartDto;
import com.capgemini.online_food_delivery.exception.CartNotFoundException;

/**********************************************************************************************
 * - @author Shashank Mathur
 * - @Description: This is a FoodCart Service Interface which is mapped to the
 * IFoodCartServiceImpl.java
 * - @since: 13-07-2022
 * 
 **********************************************************************************************/

public interface IFoodCartService {

    /**
     * @Method: addItemToFoodCart
     * @Description: This method is used to add an item to the food cart
     *               if food cart is not present, it will create a new food cart and
     *               add the item to it.
     * @param CartAddDto
     * @return CartDao
     */

    public CartDto addItemToFoodCart(CartAddDto cart);

    /**
     * @Method: increaseQuantity
     * @Description: This method is used to increase the quantity of the item in the
     *               food cart.
     * @param customerId
     * @param restaurentItemId
     * @return FoodCart return the foodCart
     * @throws CartNotFoundException
     */
    public CartDto increaseQuantity(int customerId, int restaurentItemId) throws CartNotFoundException;

    /**
     * @Method: reduceQuantity
     * @Description: This method is used to reduce the quantity of the item in the
     *               food cart.
     * @param customerId
     * @param restaurentItemId
     * @return FoodCart return the foodCart
     * @throws CartNotFoundException
     * 
     */
    public CartDto reduceQuantity(int customerId, int restaurentItemId) throws CartNotFoundException;

    /**
     * @Method: getFoodCart
     * @Description: This method is used to get the food cart of the user
     * @param customerId
     * @return CartDao
     * @throws CartNotFoundException
     */
    public CartDto getFoodCart(int customerId) throws CartNotFoundException;

    /**
     * @Method: clearFoodCart
     * @Description: This method is used to clear the food cart of the user
     * @param customerId
     * @return String
     * @throws CartNotFoundException
     */
    public String clearFoodCart(int customerId) throws CartNotFoundException;

    /**
     * @Method: deleteItemFromFoodCart
     * @Description: This method is used to delete an item from the food cart
     * @param customerId
     * @param restaurentItemId
     * @return String
     * @throws CartNotFoundException
     */
    public String deleteItemFromFoodCart(int customerId, int restaurentItemId) throws CartNotFoundException;

}
