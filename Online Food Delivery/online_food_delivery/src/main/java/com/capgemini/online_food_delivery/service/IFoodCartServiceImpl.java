package com.capgemini.online_food_delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.online_food_delivery.repository.IFoodCartRepository;
import com.capgemini.online_food_delivery.repository.IRestaurentItemsRepository;
import com.capgemini.online_food_delivery.repository.IFoodCartItemsRepository;
import com.capgemini.online_food_delivery.dto.CartAddDto;
import com.capgemini.online_food_delivery.dto.CartDto;
import com.capgemini.online_food_delivery.entity.FoodCart;
import com.capgemini.online_food_delivery.entity.RestaurentItems;
import com.capgemini.online_food_delivery.exception.CartNotFoundException;
import com.capgemini.online_food_delivery.entity.FoodCartItems;

import java.util.List;

/***************************************************************************************
 * @author: Shashank Mathur
 *          Description: This is the serviceImplementation class for the
 *          FoodCartService interface.
 *          Date: 14-07-2022
 *          version: 1.0
 **************************************************************************************/

/*
 * @Transactional: It is used to make a transaction management for the
 * application.
 * 
 */
@Service
@Transactional
public class IFoodCartServiceImpl implements IFoodCartService {

    /**
     * @Autowired: It enables to inject object dependency implicitly.
     * 
     */
    @Autowired
    private IFoodCartRepository foodCartRepository;

    @Autowired
    private IRestaurentItemsRepository restaurentItemsRepository;

    @Autowired
    private IFoodCartItemsRepository foodCartItemsRepository;

    /**
     * @Method: addItemToFoodCart
     * @Description: This method is used to add an item to the food cart
     *               if food cart is not present, it will create a new food cart and
     *               add the item to it.
     * @param foodCart
     * @param item
     * @return FoodCart return the foodCart
     */
    @Override
    public CartDto addItemToFoodCart(CartAddDto cart) {

        FoodCart foodCart1 = foodCartRepository.findByCustomerId(cart.getCustomerId());

        CartDto cartDao = new CartDto();

        if (foodCart1 == null) {

            // get RestaurentItems from the database from the ItemId
            RestaurentItems restaurentItems = restaurentItemsRepository.findByItemId(cart.getItemId());

            // create a new food cart
            FoodCart foodCart = new FoodCart();
            // Setting Data In New Food Cart
            foodCart.setCartTotal(restaurentItems.getCost());

            foodCart.setcustomerId(cart.getCustomerId());
            // Saving The Food Cart In The Database
            foodCart = foodCartRepository.save(foodCart);

            System.out.println("FoodCart created");

            // Adding The Item To The Food Cart

            FoodCartItems foodCartItems = new FoodCartItems();

            foodCartItems.setCartId(foodCart.getId());

            foodCartItems.setRestItemId(restaurentItems.getId());

            foodCartItems.setQuantity(1);

            foodCartItems.setTotalAmount(restaurentItems.getCost());

            foodCartItemsRepository.save(foodCartItems);

            System.out.println("FoodCartItems created");

            cartDao.setCartTotal(foodCart.getCartTotal());
            cartDao.setCustomerId(foodCart.getcustomerId());
            cartDao.setFoodCartItems(foodCartItemsRepository.findByCartId(foodCart.getId()));

        } else {

            System.out.println("FoodCart already exists");

            FoodCartItems foodCartItems = new FoodCartItems();

            // get RestaurentItems from the database from the ItemId

            RestaurentItems restaurentItems = restaurentItemsRepository.findByItemId(cart.getItemId());

            // If Item Already Exist
            FoodCartItems foodCartItemsCheck = foodCartItemsRepository.findByCartIdAndRestItemId(foodCart1.getId(),
                    restaurentItems.getId());

            if (foodCartItemsCheck == null) {

                foodCartItems.setCartId(foodCart1.getId());

                foodCartItems.setRestItemId(restaurentItems.getId());

                foodCartItems.setQuantity(1);

                foodCartItems.setTotalAmount(restaurentItems.getCost());

                foodCartItemsRepository.save(foodCartItems);

                foodCart1.setCartTotal(foodCart1.getCartTotal() + restaurentItems.getCost());

                foodCartRepository.save(foodCart1);

            } else {

                foodCartItemsCheck.setQuantity(foodCartItemsCheck.getQuantity() + 1);

                foodCartItemsCheck.setTotalAmount(foodCartItemsCheck.getTotalAmount() + restaurentItems.getCost());

                foodCartItemsRepository.save(foodCartItemsCheck);

            }

            cartDao.setCartTotal(foodCart1.getCartTotal());
            cartDao.setCustomerId(foodCart1.getcustomerId());
            cartDao.setFoodCartItems(foodCartItemsRepository.findByCartId(foodCart1.getId()));
        }

        return cartDao;
    }

    /**
     * @Method: increaseQuantity
     * @Description: This method is used to increase the quantity of the item in the food cart.
     * @param customerId
     * @param restaurentItemId
     * @return FoodCart return the foodCart
     * @throws CartNotFoundException
     */
    @Override
    public CartDto increaseQuantity(int customerId, int restaurentItemId) throws CartNotFoundException {

        FoodCart foodCart1 = foodCartRepository.findByCustomerId(customerId);
        CartDto result = new CartDto();

        result.setCustomerId(customerId);
        result.setCartTotal(0);
        result.setFoodCartItems(null);

        if (foodCart1 == null) {
            System.out.println("FoodCart does not exist");
            throw new CartNotFoundException("FoodCart does not exist");
        } else {
            System.out.println("FoodCart exists");

            // Get FoodCartItems from the database where the cartId is equal to the cartId
            // of the foodCart1 and restItemId is equal to the restItemId of the cart
            RestaurentItems restaurentItems = restaurentItemsRepository.findById(restaurentItemId).get();

            System.out.println("Resturent Item Retrived");

            FoodCartItems foodCartItems = foodCartItemsRepository.findByCartIdAndRestItemId(foodCart1.getId(),
                    restaurentItems.getId());
            System.out.println("CheckPoint 1");

            // Increase the quantity of the item in the food cart
            foodCartItems.setQuantity(foodCartItems.getQuantity() + 1);
            foodCartItems.setTotalAmount(foodCartItems.getTotalAmount() + restaurentItems.getCost());

            foodCartItemsRepository.save(foodCartItems);
            System.out.println("CheckPoint 2");

            // Update the cart total of the food cart
            foodCart1.setCartTotal(foodCart1.getCartTotal() + restaurentItems.getCost());
            foodCartRepository.save(foodCart1);
            System.out.println("CheckPoint 3");

            // Get the updated food cart items from the database
            result.setCartTotal(foodCart1.getCartTotal());
            result.setCustomerId(foodCart1.getcustomerId());
            result.setFoodCartItems(foodCartItemsRepository.findByCartId(foodCart1.getId()));
            System.out.println("CheckPoint 4");

        }

        System.out.println("CheckPoint 5");
        return result;
    }

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
    @Override
    public CartDto reduceQuantity(int customerId, int restaurentItemId) throws CartNotFoundException {
        FoodCart foodCart1 = foodCartRepository.findByCustomerId(customerId);
        CartDto result = new CartDto();
        result.setCustomerId(customerId);
        result.setCartTotal(0);
        result.setFoodCartItems(null);
        if (foodCart1 == null) {
            System.out.println("FoodCart does not exist");
            throw new CartNotFoundException("FoodCart does not exist");
        } else {
            System.out.println("FoodCart exists");

            // Get FoodCartItems from the database where the cartId is equal to the cartId
            // of the foodCart1 and restItemId is equal to the restItemId of the cart
            RestaurentItems restaurentItems = restaurentItemsRepository.findById(restaurentItemId).get();
            System.out.println("Resturent Item Retrived");
            FoodCartItems foodCartItems = foodCartItemsRepository.findByCartIdAndRestItemId(foodCart1.getId(),
                    restaurentItems.getId());
            System.out.println("CheckPoint 1");

            // If the quantity of the item is 1, delete the item from the food cart
            if (foodCartItems.getQuantity() == 1) {
                foodCartItemsRepository.delete(foodCartItems);
            } else {
                // Reduce the quantity of the item in the food cart
                foodCartItems.setQuantity(foodCartItems.getQuantity() - 1);
                foodCartItems.setTotalAmount(foodCartItems.getTotalAmount() - restaurentItems.getCost());
                foodCartItemsRepository.save(foodCartItems);
                System.out.println("CheckPoint 2");
            }

            // Update the cart total of the food cart
            foodCart1.setCartTotal(foodCart1.getCartTotal() - restaurentItems.getCost());
            foodCartRepository.save(foodCart1);
            System.out.println("CheckPoint 3");
            // Get the updated food cart items from the database
            result.setCartTotal(foodCart1.getCartTotal());
            result.setCustomerId(foodCart1.getcustomerId());
            result.setFoodCartItems(foodCartItemsRepository.findByCartId(foodCart1.getId()));
            System.out.println("CheckPoint 4");
        }

        return (result);
    }

    /**
     * @Method: getFoodCart
     * @Description: This method is used to get the food cart of the user
     * @param customerId
     * @return CartDao
     * @throws CartNotFoundException
     */
    @Override
    public CartDto getFoodCart(int customerId) throws CartNotFoundException {
        FoodCart foodCart1 = foodCartRepository.findByCustomerId(customerId);
        CartDto result = new CartDto();
        result.setCustomerId(customerId);
        result.setCartTotal(0);
        result.setFoodCartItems(null);
        if (foodCart1 == null) {
            System.out.println("FoodCart does not exist");
            throw new CartNotFoundException("FoodCart does not exist");
        } else {
            System.out.println("FoodCart exists");

            // Get the food cart items from the database
            result.setCartTotal(foodCart1.getCartTotal());
            result.setCustomerId(foodCart1.getcustomerId());
            result.setFoodCartItems(foodCartItemsRepository.findByCartId(foodCart1.getId()));
        }
        return result;
    }

    /**
     * @Method: clearFoodCart
     * @Description: This method is used to clear the food cart of the user
     * @param customerId
     * @return String
     * @throws CartNotFoundException
     */
    @Override
    public String clearFoodCart(int customerId) throws CartNotFoundException {
        FoodCart foodCart1 = foodCartRepository.findByCustomerId(customerId);
        if (foodCart1 == null) {
            System.out.println("FoodCart does not exist");
            throw new CartNotFoundException("FoodCart does not exist");
        } else {
            System.out.println("FoodCart exists");
            // Delete the food cart items from the database

            List<FoodCartItems> foodCartItems = foodCartItemsRepository.findByCartId(foodCart1.getId());

            for (FoodCartItems foodCartItem : foodCartItems) {
                foodCartItemsRepository.delete(foodCartItem);
            }

            // Delete the food cart from the database
            foodCartRepository.delete(foodCart1);
            return "FoodCart cleared";
        }
    }

    /**
     * @Method: deleteItemFromFoodCart
     * @Description: This method is used to delete an item from the food cart
     * @param customerId
     * @param itemId
     * @return String
     * @throws CartNotFoundException
     */
    @Override
    public String deleteItemFromFoodCart(int customerId, int restaurentItemId) throws CartNotFoundException {
        FoodCart foodCart1 = foodCartRepository.findByCustomerId(customerId);
        if (foodCart1 == null) {
            System.out.println("FoodCart does not exist");
            throw new CartNotFoundException("FoodCart does not exist");
        } else {
            System.out.println("FoodCart exists");
            // Delete the food cart items from the database
            RestaurentItems restaurentItems = restaurentItemsRepository.findById(restaurentItemId).get();
            FoodCartItems foodCartItems = foodCartItemsRepository.findByCartIdAndRestItemId(foodCart1.getId(),
                    restaurentItems.getId());
            foodCart1.setCartTotal(foodCart1.getCartTotal() - foodCartItems.getTotalAmount());
            foodCartItemsRepository.delete(foodCartItems);
            return "Item deleted from FoodCart";
        }
    }

}
