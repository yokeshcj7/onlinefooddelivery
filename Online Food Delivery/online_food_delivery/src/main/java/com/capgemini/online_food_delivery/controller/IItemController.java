package com.capgemini.online_food_delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.online_food_delivery.dto.ItemDto;
import com.capgemini.online_food_delivery.dto.ItemShowDto;
import com.capgemini.online_food_delivery.dto.ItemDetailsDto;
import com.capgemini.online_food_delivery.entity.Item;
import com.capgemini.online_food_delivery.exception.ItemNotFoundException;
import com.capgemini.online_food_delivery.service.IItemServiceImpl;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/Item")
public class IItemController {

    /**
     * @Autowired: It enables to inject object dependency implicitly.
     * 
     */
    @Autowired
    private IItemServiceImpl itemService;

    /**
     * @Method: addItem
     * @Description: This method is used to add the Item to the database.
     * @param item
     * @return Item object
     */
    @PostMapping("/addItem")
    public ResponseEntity<Item> addItem(@RequestBody ItemDto item) {

        return new ResponseEntity<Item>(itemService.addItem(item), HttpStatus.OK);
    }

    /**
     * @Method: getAllItems
     * @Description: This method is used to get All the Item from the database.
     * @param
     * @return List of Item object
     */
    @GetMapping("/getAllItems")
    public ResponseEntity<List<ItemShowDto>> getAllItems() throws ItemNotFoundException {

        return new ResponseEntity<List<ItemShowDto>>(itemService.getAllItems(), HttpStatus.OK);
    }

    /**
     * @Method: updateItem
     * @Description: This method is used to update the Item in the database.
     * @param item
     * @return ItemShow object
     */
    @PostMapping("/updateItem")
    public ResponseEntity<ItemShowDto> updateItem(@RequestBody ItemShowDto item) throws ItemNotFoundException {

        return new ResponseEntity<ItemShowDto>(itemService.updateItem(item), HttpStatus.OK);
    }

    /**
     * @Method: getItemById
     * @Description: This method is used to get the Item by Id from the database.
     * @param id
     * @return ItemShow object
     */
    @GetMapping("/getItemById/{id}")
    public ResponseEntity<ItemShowDto> getItemById(@PathVariable("id") int id) throws ItemNotFoundException {

        return new ResponseEntity<ItemShowDto>(itemService.getItemById(id), HttpStatus.OK);
    }

    /**
     * @Method: removeItem
     * @Description: This method is used to remove the Item from the database.
     * @param id
     * @return ItemShow object
     */
    @DeleteMapping("/removeItem/{id}")
    public ResponseEntity<ItemShowDto> removeItem(@PathVariable("id") int id) throws ItemNotFoundException {

        return new ResponseEntity<ItemShowDto>(itemService.removeItem(id), HttpStatus.OK);
    }

    /**
     * @Method: getItemByCategoryId
     * @Description: This method is used to get the Item by Category from the
     *               database.
     * @param categoryId
     * @return List of ItemShow object
     */
    @GetMapping("/getItemByCategoryId/{categoryId}")
    public ResponseEntity<List<ItemShowDto>> getItemByCategoryId(@PathVariable("categoryId") int categoryId)
            throws ItemNotFoundException {

        return new ResponseEntity<List<ItemShowDto>>(itemService.getItemByCategoryId(categoryId), HttpStatus.OK);
    }

    /**
     * @Method: getItemByRestaurentId
     * @Description: This method is used to get the Item by Restaurant from the
     *               database.
     * @param restaurantId
     * @return List of ItemShow object
     */
    @GetMapping("/getItemByRestaurentId/{restaurantId}")
    public ResponseEntity<List<ItemShowDto>> getItemByRestaurentId(@PathVariable("restaurantId") int restaurantId)
            throws ItemNotFoundException {

        return new ResponseEntity<List<ItemShowDto>>(itemService.getItemByRestaurentId(restaurantId), HttpStatus.OK);
    }

    /**
     * @Method: getItemDetailesByRestaurantItemId
     *         Description: This method is used to get the Item Details by Restaurant
     *        Item Id from the database.
     * @param restaurantItemId
     * @return ItemDetailsDto
     */
    @GetMapping("/getItemDetailesByRestaurantItemId/{restaurantItemId}")
    public ResponseEntity<ItemDetailsDto> getItemDetailesByRestaurantItemId(
            @PathVariable("restaurantItemId") int restaurantItemId) throws ItemNotFoundException {

        return new ResponseEntity<ItemDetailsDto>(itemService.getItemDetailesByRestaurantItemId(restaurantItemId),
                HttpStatus.OK);
    }

    /**
     * @Method: getItemDetailesByItemId
     *         Description: This method is used to get the Item Details by Restaurant
     *        Item Id from the database.
     * @param ItemId
     * @return ItemDetailsDto
     */
    @GetMapping("/getItemDetailesByItemId/{ItemId}")
    public ResponseEntity<ItemDetailsDto> getItemDetailesByItemId(@PathVariable("ItemId") int ItemId)
            throws ItemNotFoundException {

        return new ResponseEntity<ItemDetailsDto>(itemService.getItemDetailesByItemId(ItemId), HttpStatus.OK);
    }



}
