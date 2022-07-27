package com.capgemini.online_food_delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.online_food_delivery.dto.OrderDetailsDto;
import com.capgemini.online_food_delivery.service.OrderService;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/orderDetails")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@PostMapping("/addOrder")
	public OrderDetailsDto addOrder(@RequestBody OrderDetailsDto orderDetailsdto) {
		return orderService.addOrder(orderDetailsdto);
	}
	
	@PostMapping("/addOrderItems")
	public OrderDetailsDto addOrderItems(@RequestBody OrderDetailsDto orderDetailsdto) {
		return orderService.addOrdeItems(orderDetailsdto);
	}

	@GetMapping("/viewByCustomer/{CustomerId}")
	public List<OrderDetailsDto> viewAllOrder(@PathVariable int CustomerId) {
		return orderService.viewAllOrder(CustomerId);
	}

	@PutMapping("/updateOrder")
	public String updateOrder(@RequestBody OrderDetailsDto orderDetailsdto) {
		return orderService.updateOrder(orderDetailsdto);
	}

	@DeleteMapping("/removeOrder/{orderId}")
	public String removeOrder(@PathVariable int orderId) {
		return orderService.removeOrder(orderId);
	}

	@GetMapping("/viewById/{OrderId}")
	public OrderDetailsDto viewOrderById(@PathVariable int OrderId) {
		return orderService.viewOrderById(OrderId);
	}

}
