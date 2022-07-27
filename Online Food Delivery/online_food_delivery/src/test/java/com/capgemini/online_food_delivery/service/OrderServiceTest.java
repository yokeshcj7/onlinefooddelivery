package com.capgemini.online_food_delivery.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.online_food_delivery.dto.OrderDetailsDto;
import com.capgemini.online_food_delivery.entity.Customer;
import com.capgemini.online_food_delivery.entity.OrderDetails;
import com.capgemini.online_food_delivery.entity.OrderItems;
import com.capgemini.online_food_delivery.exception.OrderNotFoundException;
import com.capgemini.online_food_delivery.repository.IOrderItemsRepository;
import com.capgemini.online_food_delivery.repository.OrderRepository;

@SpringBootTest
public class OrderServiceTest {
	@InjectMocks
    OrderService orderService = new OrderService();
	@Mock
	OrderRepository orderRepository;
	@Mock
	IOrderItemsRepository orderItemsRepository;
	
	@Test
	public void addOrderTest() {
		OrderDetails orderDetails=new OrderDetails();
		orderDetails.setCustomerId(1);
		orderDetails.setId(1);
		orderDetails.setOrderAmount(300);
		orderDetails.setOrderDate(LocalDateTime.now());
		orderDetails.setStatus("in process");
		
		OrderDetailsDto orderDetailsDto=new OrderDetailsDto();
		orderDetailsDto.setCustomerId(1);
		orderDetailsDto.setId(1);
		orderDetailsDto.setOrderAmount(300);
		orderDetailsDto.setOrderDate(LocalDateTime.now());
		orderDetailsDto.setStatus("in process");
		
		List<OrderItems> orderItems=new ArrayList<OrderItems>();
		
		OrderItems orderItem1=new OrderItems();
		orderItem1.setAmmount(100);
		orderItem1.setId(1);
		orderItem1.setItemId(1);
		orderItem1.setQuantity(3);
		orderItems.add(orderItem1);
		
		orderDetailsDto.setOrderItems(orderItems);
		 when(orderRepository.save(orderDetails)).thenReturn(orderDetails);
	     when(orderItemsRepository.save(orderItem1)).thenReturn(orderItem1);   
	     when(orderItemsRepository.findByOrderId(orderDetails.getId())).thenReturn(orderItems);
	        OrderDetailsDto newOrder = orderService.addOrder(orderDetailsDto);
	        
	        assertEquals(100,newOrder.getOrderAmount());
	        
	        
	        }
	@Test
	public void deleteOrder() {
		OrderDetails orderDetails=new OrderDetails();
		orderDetails.setCustomerId(1);
		orderDetails.setId(1);
		orderDetails.setOrderAmount(300);
		orderDetails.setOrderDate(LocalDateTime.now());
		orderDetails.setStatus("in process");
		Optional<OrderDetails> container=Optional.of(orderDetails);
		when(orderRepository.findById(1)).thenReturn(container);
		
        
//      Product myProduct = productService.getProductById(100);
      
      String temp=orderService.removeOrder(orderDetails.getId());
      verify(orderRepository,times(1)).findById(1);
      verify(orderRepository,times(1)).deleteById(100);
	}
	@Test
	public void getOrderTest() {
		OrderDetails orderDetails=new OrderDetails();
		orderDetails.setCustomerId(1);
		orderDetails.setId(1);
		orderDetails.setOrderAmount(300);
		orderDetails.setOrderDate(LocalDateTime.now());
		orderDetails.setStatus("in process");
		
		OrderItems orderItem1=new OrderItems();
		orderItem1.setAmmount(100);
		orderItem1.setId(1);
		orderItem1.setItemId(1);
		orderItem1.setQuantity(3);
		
		Optional<OrderDetails> container=Optional.of(orderDetails);
		when(orderRepository.findById(1)).thenReturn(container);
		OrderDetailsDto newOrder=orderService.viewOrderById(orderDetails.getId());
		assertEquals(100,newOrder.getOrderAmount());
	}
	
	@Test
	public void getOrderByCustomerId() {
		OrderDetails orderDetails=new OrderDetails();
		orderDetails.setCustomerId(1);
		orderDetails.setId(1);
		orderDetails.setOrderAmount(300);
		orderDetails.setOrderDate(LocalDateTime.now());
		orderDetails.setStatus("in process");
		
		OrderDetails orderDetails2=new OrderDetails();
		orderDetails.setCustomerId(2);
		orderDetails.setId(2);
		orderDetails.setOrderAmount(500);
		orderDetails.setOrderDate(LocalDateTime.now());
		orderDetails.setStatus("in process");
		
		Customer customer=new Customer();
		customer.setId(1);
		customer.setAge(21);
		customer.setaddress_id(1);
		customer.setEmail("abc@gmail.com");
		customer.setFirstName("yokesh");
		customer.setLastName("C");
		customer.setGender("male");
		customer.setMobileNumber("9944117099");
		customer.setuserId(1);
		//Optional<OrderDetails> container=Optional.of(orderDetails);
		//when(orderRepository.findById(1)).thenReturn(container);
		List<OrderDetails> container=new ArrayList<OrderDetails>();
		List<OrderDetailsDto> result=new ArrayList<OrderDetailsDto>();
		container.add(orderDetails);
		container.add(orderDetails2);
		when(orderRepository.findAll()).thenReturn(container);
		result=orderService.viewAllOrder(customer.getId());
		assertEquals(300,result.get(0).getOrderAmount());
	}
	@Test
	public void getOrderWithException() {
		when(orderRepository.findById(100)).thenThrow(OrderNotFoundException.class);
		
		OrderDetails orderDetails=new OrderDetails();
		orderDetails.setCustomerId(100);
		orderDetails.setId(1);
		orderDetails.setOrderAmount(300);
		orderDetails.setOrderDate(LocalDateTime.now());
		orderDetails.setStatus("in process");
        
        assertThrows(OrderNotFoundException.class,()->orderService.viewOrderById(orderDetails.getId()));
	}
}
