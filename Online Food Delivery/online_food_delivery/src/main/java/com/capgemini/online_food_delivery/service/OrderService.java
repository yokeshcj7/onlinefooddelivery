package com.capgemini.online_food_delivery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.online_food_delivery.entity.OrderDetails;
import com.capgemini.online_food_delivery.entity.OrderItems;
import com.capgemini.online_food_delivery.exception.OrderNotFoundException;
import com.capgemini.online_food_delivery.repository.OrderRepository;
import com.capgemini.online_food_delivery.repository.IOrderItemsRepository;
import com.capgemini.online_food_delivery.dto.OrderDetailsDto;

@Service
public class OrderService {

	@Autowired
	private IOrderItemsRepository orderItemsRepository;

	@Autowired
	OrderRepository orderRepository;

	public OrderDetailsDto addOrder(OrderDetailsDto orderDetails) {

		OrderDetails orderDetails1 = new OrderDetails();
		orderDetails1.setCustomerId(orderDetails.getCustomerId());
		orderDetails1.setOrderDate(LocalDateTime.now());
		orderDetails1.setStatus(orderDetails.getStatus());
		orderDetails1.setOrderAmount(orderDetails.getOrderAmount());

		orderDetails1 = orderRepository.save(orderDetails1);

		OrderDetailsDto result = new OrderDetailsDto();
		result.setId(orderDetails1.getId());
		result.setOrderDate(orderDetails1.getOrderDate());
		result.setCustomerId(orderDetails1.getCustomerId());
		result.setStatus(orderDetails1.getStatus());
		result.setOrderAmount(orderDetails1.getOrderAmount());

		result.setOrderItems(orderItemsRepository.findByOrderId(orderDetails1.getId()));

		return result;

	}

	public OrderDetailsDto addOrdeItems (OrderDetailsDto orderDetails) throws OrderNotFoundException {
		Optional<OrderDetails> container = orderRepository.findById(orderDetails.getId());
		if(container.isPresent()) {
			for(OrderItems orderItem : orderDetails.getOrderItems()) {
				orderItem.setOrderId(orderDetails.getId());
				orderItemsRepository.save(orderItem);
			}	
		}
		else {
			throw new OrderNotFoundException("Order not found");
		}
		OrderDetailsDto result = new OrderDetailsDto();
		result.setId(orderDetails.getId());
		result.setOrderDate(orderDetails.getOrderDate());
		result.setCustomerId(orderDetails.getCustomerId());
		result.setStatus(orderDetails.getStatus());
		result.setOrderAmount(orderDetails.getOrderAmount());
		result.setOrderItems(orderItemsRepository.findByOrderId(orderDetails.getId()));
		return result;
	}

	public List<OrderDetailsDto> viewAllOrder(int cust_id) {

		List<OrderDetailsDto> result = new ArrayList<OrderDetailsDto>();

		List<OrderDetails> orderDetails = orderRepository.findByCustomerId(cust_id);

		for (OrderDetails orderDetail : orderDetails) {
			OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
			orderDetailsDto.setId(orderDetail.getId());
			orderDetailsDto.setOrderDate(orderDetail.getOrderDate());
			orderDetailsDto.setCustomerId(orderDetail.getCustomerId());
			orderDetailsDto.setStatus(orderDetail.getStatus());
			orderDetailsDto.setOrderAmount(orderDetail.getOrderAmount());
			orderDetailsDto.setOrderItems(orderItemsRepository.findByOrderId(orderDetail.getId()));
			result.add(orderDetailsDto);
		}
		return result;

	}

	public String updateOrder(OrderDetailsDto orderDetailsDto) {

		OrderDetails orderDetails = orderRepository.findById(orderDetailsDto.getId()).get();

		if (orderDetails == null) {
			System.out.println(orderDetailsDto.getStatus());
			throw new OrderNotFoundException("Order not found");
		}

		orderDetails.setStatus(orderDetailsDto.getStatus());
		orderDetails.setOrderAmount(orderDetailsDto.getOrderAmount());
		orderDetails.setOrderDate(orderDetailsDto.getOrderDate());
		orderDetails.setCustomerId(orderDetailsDto.getCustomerId());

		System.out.println(orderDetails.getStatus());

		orderDetails = orderRepository.save(orderDetails);

		List<OrderItems> orderItems = orderDetailsDto.getOrderItems();
		for (OrderItems orderItem : orderItems) {
			OrderItems orderItem1 = orderItemsRepository.findById(orderItem.getId()).get();

			orderItem1.setItemId(orderItem.getItemId());
			orderItem1.setAmmount(orderItem.getAmmount());
			orderItem1.setQuantity(orderItem.getQuantity());
			orderItem1.setRestaurentId(orderItem.getRestaurentId());
			orderItemsRepository.save(orderItem1);
		}

		return "Order updated successfully";

	}

	public String removeOrder(int orderDetails) {

		OrderDetails orderDetails1 = orderRepository.findById(orderDetails).get();
		if (orderDetails1 == null) {
			throw new OrderNotFoundException("Order not found");
		}

		List<OrderItems> orderItems = orderItemsRepository.findByOrderId(orderDetails);
		for (OrderItems orderItem : orderItems) {
			orderItemsRepository.delete(orderItem);
		}

		orderRepository.delete(orderDetails1);
		return "Order removed successfully";

	}

	public OrderDetailsDto viewOrderById(int ord_id) {
		Optional<OrderDetails> orderDetails = orderRepository.findById(ord_id);
		if (orderDetails.isPresent()) {
			OrderDetails temp = orderDetails.get();
			OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
			orderDetailsDto.setId(temp.getId());
			orderDetailsDto.setOrderDate(temp.getOrderDate());
			orderDetailsDto.setCustomerId(temp.getCustomerId());
			orderDetailsDto.setStatus(temp.getStatus());
			orderDetailsDto.setOrderAmount(temp.getOrderAmount());
			orderDetailsDto.setOrderItems(orderItemsRepository.findByOrderId(temp.getId()));
			return orderDetailsDto;
		}
		return null;
	}
}
