package com.capgemini.online_food_delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.online_food_delivery.dto.ItemDetailsDto;
import com.capgemini.online_food_delivery.dto.ItemDto;
import com.capgemini.online_food_delivery.dto.ItemShowDto;
import com.capgemini.online_food_delivery.entity.Item;
import com.capgemini.online_food_delivery.repository.IItemRepository;
import com.capgemini.online_food_delivery.entity.RestaurentItems;
import com.capgemini.online_food_delivery.exception.ItemNotFoundException;
import com.capgemini.online_food_delivery.repository.IRestaurentItemsRepository;
import com.capgemini.online_food_delivery.repository.ICategoryRepository;
import com.capgemini.online_food_delivery.repository.IRestaurentRepository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

/***************************************************************************************
 * @author: Shashank Mathur
 *          Description: This is the serviceImplementation class for the
 *          FoodCartService interface.
 *          Date: 13-07-2022
 *          version: 1.0
 **************************************************************************************/

/*
 * @Transactional: It is used to make a transaction management for the
 * application.
 * 
 */
@Service
@Transactional
public class IItemServiceImpl implements IIteamService {

    /**
     * @Autowired: It enables to inject object dependency implicitly.
     * 
     */
    @Autowired
    private IItemRepository itemRepository;

    @Autowired
    private IRestaurentItemsRepository restaurentItemsRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private IRestaurentRepository restaurentRepository;

    /***********************************************************************
     * @Method: addItem
     *          Description: This method is used to add the Item to the database.
     * 
     * @param ItemDto
     * @return Item object
     ***********************************************************************/

    @Override
    public Item addItem(ItemDto item) {

        System.out.println(item);
        // Make Item objet
        Item itemObject = new Item();
        itemObject.setName(item.getName());
        itemObject.setcategoryId(item.getCategoryId());

        System.out.println(itemObject);

        // Save Item object
        itemRepository.save(itemObject);

        // Make RestaurantItems object
        RestaurentItems restaurentItems = new RestaurentItems();
        restaurentItems.setitemId(itemObject.getId());

        restaurentItems.setrestId(item.getRestaurentId());
        restaurentItems.setCost(item.getCost());

        // Save RestaurantItems object
        restaurentItemsRepository.save(restaurentItems);

        return (itemObject);

    }

    /***********************************************************************
     * @Method: getItem
     *          Description: This method is used to get All the Item from the
     *          database.
     * 
     * @param
     * @return List ItemShow object
     ***********************************************************************/
    @Override
    public List<ItemShowDto> getAllItems() throws ItemNotFoundException {

        List<Item> itemList = itemRepository.findAll();
        List<ItemShowDto> ItemShowList = new ArrayList<ItemShowDto>();

        if (itemList.size() <= 0) {
            throw new ItemNotFoundException("No Items Found");
        } else {

            for (Item item : itemList) {

                // Make ItemShow object

                ItemShowDto itemShow = new ItemShowDto();
                itemShow.setItemId(item.getId());
                itemShow.setName(item.getName());
                itemShow.setCategoryId(item.getcategoryId());

                // Retrieve RestaurantItems object
                RestaurentItems restaurentItems = restaurentItemsRepository.findByitemId(item.getId());

                // Set restaurentId and cost in ItemShow object

                itemShow.setRestaurentId(restaurentItems.getrestId());
                itemShow.setCost(restaurentItems.getCost());

                ItemShowList.add(itemShow);

            }
        }
        return ItemShowList;

    }

    /***********************************************************************
     * @Method: Update Item
     *          Description: This method is used to update the Item in the database.
     * 
     * @param ItemShowDto
     * @return ItemShow object
     ***********************************************************************/
    @Override
    public ItemShowDto updateItem(ItemShowDto item) throws ItemNotFoundException {

        Item itemObject = itemRepository.findById(item.getItemId()).get();

        if (itemObject == null) {
            throw new ItemNotFoundException("Item Not Found Id: " + item.getItemId());
        }

        itemObject.setName(item.getName());
        itemObject.setcategoryId(item.getCategoryId());

        // Save Item object
        itemRepository.save(itemObject);

        // Make RestaurantItems object
        RestaurentItems restaurentItems = restaurentItemsRepository.findByitemId(item.getItemId());
        restaurentItems.setrestId(item.getRestaurentId());
        restaurentItems.setCost(item.getCost());

        // Save RestaurantItems object
        restaurentItemsRepository.save(restaurentItems);

        return (item);
    }

    /***********************************************************************
     * @Method: getItemById
     *          Description: This method is used to get the Item by Id from the
     *          database.
     * 
     * @param id
     * @return ItemShow object
     ***********************************************************************/
    @Override
    public ItemShowDto getItemById(int id) throws ItemNotFoundException {

        Optional<Item> optionalItemObject = itemRepository.findById(id);

        if (optionalItemObject.isEmpty()) {
            throw new ItemNotFoundException("Item Not Found Id: " + id);
        }

        Item itemObject = optionalItemObject.get();

        // Make ItemShow object
        ItemShowDto itemShow = new ItemShowDto();
        itemShow.setItemId(itemObject.getId());
        itemShow.setName(itemObject.getName());
        itemShow.setCategoryId(itemObject.getcategoryId());

        // Retrieve RestaurantItems object
        RestaurentItems restaurentItems = restaurentItemsRepository.findByitemId(itemObject.getId());

        // Set restaurentId and cost in ItemShow object
        itemShow.setRestaurentId(restaurentItems.getrestId());
        itemShow.setCost(restaurentItems.getCost());

        return itemShow;
    }

    /***********************************************************************
     * @Method: Remove Item
     *          Description: This method is used to remove the Item from the
     *          database.
     * 
     * @param id
     * @return ItemShow object
     ***********************************************************************/
    @Override
    public ItemShowDto removeItem(int id) throws ItemNotFoundException {

        Item itemObject = itemRepository.findById(id).get();

        if (itemObject == null) {
            throw new ItemNotFoundException("Item Not Found Id: " + id);
        }

        // Make ItemShow object
        ItemShowDto itemShow = new ItemShowDto();
        itemShow.setItemId(itemObject.getId());
        itemShow.setName(itemObject.getName());
        itemShow.setCategoryId(itemObject.getcategoryId());

        // Retrieve RestaurantItems object
        RestaurentItems restaurentItems = restaurentItemsRepository.findByitemId(itemObject.getId());

        // Set restaurentId and cost in ItemShow object
        itemShow.setRestaurentId(restaurentItems.getrestId());
        itemShow.setCost(restaurentItems.getCost());

        // Remove Item object
        itemRepository.deleteById(id);

        // Remove RestaurantItems object
        restaurentItemsRepository.deleteById(restaurentItems.getId());

        return itemShow;
    }

    /***********************************************************************
     * @Method: getItemByCategoryId
     *          Description: This method is used to get the Item by CategoryId
     *          from the database.
     * 
     * @param categoryId
     * @return List ItemShow object
     ***********************************************************************/
    @Override
    public List<ItemShowDto> getItemByCategoryId(int categoryId) throws ItemNotFoundException {

        List<Item> itemList = itemRepository.getItemByCategoryId(categoryId);
        List<ItemShowDto> ItemShowList = new ArrayList<ItemShowDto>();

        if (itemList.isEmpty()) {
            throw new ItemNotFoundException("No Items Found Of Category Id: " + categoryId);
        }

        for (Item item : itemList) {

            // Make ItemShow object

            ItemShowDto itemShow = new ItemShowDto();
            itemShow.setItemId(item.getId());
            itemShow.setName(item.getName());
            itemShow.setCategoryId(item.getcategoryId());

            // Retrieve RestaurantItems object
            RestaurentItems restaurentItems = restaurentItemsRepository.findByitemId(item.getId());

            // Set restaurentId and cost in ItemShow object

            itemShow.setRestaurentId(restaurentItems.getrestId());
            itemShow.setCost(restaurentItems.getCost());

            ItemShowList.add(itemShow);

        }
        return ItemShowList;

    }

    /***********************************************************************
     * @Method: getItemByRestaurentId
     *          Description: This method is used to get the Item by RestaurentId
     *          from the database.
     * 
     * @param restaurentId
     * @return List ItemShow object
     ***********************************************************************/
    @Override
    public List<ItemShowDto> getItemByRestaurentId(int restaurentId) throws ItemNotFoundException {

        List<RestaurentItems> restaurentItemsList = restaurentItemsRepository.findByRestId(restaurentId);
        List<ItemShowDto> ItemShowList = new ArrayList<ItemShowDto>();

        if (restaurentItemsList.isEmpty()) {
            throw new ItemNotFoundException("No Items Found Of Restaurent Id: " + restaurentId);
        }

        for (RestaurentItems restItem : restaurentItemsList) {

            // Make ItemShow object
            ItemShowDto itemShow = new ItemShowDto();
            itemShow.setItemId(restItem.getitemId());
            itemShow.setRestaurentId(restaurentId);
            itemShow.setCost(restItem.getCost());

            // Retrieve Item object
            Item itemObject = itemRepository.findById(restItem.getitemId()).get();
            itemShow.setName(itemObject.getName());
            itemShow.setCategoryId(itemObject.getcategoryId());

            ItemShowList.add(itemShow);

        }
        return ItemShowList;
    }

    /**
     * @Method: getItemDetailesByRestaurantItemId
     *          Description: This method is used to get the Item Details by
     *          Restaurant
     *          Item Id from the database.
     * @param restaurantItemId
     * @return ItemDetailsDto
     */
    @Override
    public ItemDetailsDto getItemDetailesByRestaurantItemId(int restaurantItemId) throws ItemNotFoundException {
        RestaurentItems restaurentItems = restaurentItemsRepository.findById(restaurantItemId).get();
        if (restaurentItems == null) {
            throw new ItemNotFoundException("Item Not Found Id: " + restaurantItemId);
        }
        ItemDetailsDto itemDetailsDto = new ItemDetailsDto();

        Item itemObject = itemRepository.findById(restaurentItems.getitemId()).get();

        itemDetailsDto.setItemName(itemObject.getName());

        itemDetailsDto.setCategory(categoryRepository.findById(itemObject.getcategoryId()).get().getName());

        itemDetailsDto.setRestaurentName(
                restaurentRepository.findById(restaurentItems.getrestId()).get().getRestaurentName());

        return itemDetailsDto;
    }

    /**
     * @Method: getItemDetailesByItemId
     *          Description: This method is used to get the Item Details by
     *          Restaurant
     *          Item Id from the database.
     * @param ItemId
     * @return ItemDetailsDto
     */
    @Override
    public ItemDetailsDto getItemDetailesByItemId(int ItemId) throws ItemNotFoundException {
        Item itemObject = itemRepository.findById(ItemId).get();
        if (itemObject == null) {
            throw new ItemNotFoundException("Item Not Found Id: " + ItemId);
        }
        ItemDetailsDto itemDetailsDto = new ItemDetailsDto();
        itemDetailsDto.setItemName(itemObject.getName());
        itemDetailsDto.setCategory(categoryRepository.findById(itemObject.getcategoryId()).get().getName());
        // Retrieve RestaurantItems object
        RestaurentItems restaurentItems = restaurentItemsRepository.findByitemId(ItemId);
        itemDetailsDto.setRestaurentName(
                restaurentRepository.findById(restaurentItems.getrestId()).get().getRestaurentName());
        return itemDetailsDto;

    }
}