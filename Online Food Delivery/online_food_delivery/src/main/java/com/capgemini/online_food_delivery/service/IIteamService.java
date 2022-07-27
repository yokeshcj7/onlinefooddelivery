package com.capgemini.online_food_delivery.service;

import com.capgemini.online_food_delivery.dto.ItemDto;
import com.capgemini.online_food_delivery.dto.ItemShowDto;
import com.capgemini.online_food_delivery.dto.ItemDetailsDto;
import com.capgemini.online_food_delivery.entity.Item;
import com.capgemini.online_food_delivery.exception.ItemNotFoundException;

import java.util.List;

public interface IIteamService {

    /***********************************************************************
     * Method: addItem
     * Description: This method is used to add the Item to the database.
     * 
     * @param ItemDto
     * @return Item object
     ***********************************************************************/
    public Item addItem(ItemDto item);

    /***********************************************************************
     * Method: getAllItem
     * Description: This method is used to get All the Item from the database.
     * 
     * @param
     * @return List ItemShow object
     ***********************************************************************/
    public List<ItemShowDto> getAllItems() throws ItemNotFoundException;

    /***********************************************************************
     * Method: Update Item
     * Description: This method is used to update the Item in the database.
     * 
     * @param ItemShowDto
     * @return ItemShow object
     ***********************************************************************/
    public ItemShowDto updateItem(ItemShowDto item) throws ItemNotFoundException;

    /***********************************************************************
     * Method: getItemById
     * Description: This method is used to get the Item by Id from the database.
     * 
     * @param id
     * @return ItemShow object
     ***********************************************************************/
    public ItemShowDto getItemById(int id) throws ItemNotFoundException;

    /***********************************************************************
     * Method: Remove Item
     * Description: This method is used to remove the Item from the database.
     * 
     * @param id
     * @return ItemShow object
     ***********************************************************************/
    public ItemShowDto removeItem(int id) throws ItemNotFoundException;

    /***********************************************************************
     * @Method: getItemByCategory
     *          Description: This method is used to get the Item by Category from
     *          the
     *          database.
     *
     * @param categoryId
     * @return List ItemShow object
     ***********************************************************************/
    public List<ItemShowDto> getItemByCategoryId(int categoryId) throws ItemNotFoundException;

    /***********************************************************************
     * @Method: getItemByRestaurantId
     *          Description: This method is used to get the Item by Restaurant
     *          from the database.
     * @param restaurantId
     * @return List ItemShow object
     ***********************************************************************/
    public List<ItemShowDto> getItemByRestaurentId(int restaurantId) throws ItemNotFoundException;


    /**
     * @Method: getItemDetailesByRestaurantItemId
     *         Description: This method is used to get the Item Details by Restaurant
     *        Item Id from the database.
     * @param restaurantItemId
     * @return ItemDetailsDto
     */
    public ItemDetailsDto getItemDetailesByRestaurantItemId(int restaurantItemId) throws ItemNotFoundException;
    

    /**
     * @Method: getItemDetailesByItemId
     *         Description: This method is used to get the Item Details by Restaurant
     *        Item Id from the database.
     * @param ItemId
     * @return ItemDetailsDto
     */
    public ItemDetailsDto getItemDetailesByItemId(int ItemId) throws ItemNotFoundException;
}
