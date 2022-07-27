package com.capgemini.online_food_delivery.controller;

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

import com.capgemini.online_food_delivery.entity.Restaurent;
import com.capgemini.online_food_delivery.exception.RestaurentNotFoundException;
import com.capgemini.online_food_delivery.service.RestaurentService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/Restaurent")
public class RestaurentController {
	@Autowired
	RestaurentService restaurentService;

	@PostMapping("/addRestaurent")
	public Restaurent addRestaurent(@RequestBody Restaurent restaurent) {
		return restaurentService.addRestaurent(restaurent);
	}

	@PutMapping("/updateRestaurent")
	public Restaurent updateRestaurent(@RequestBody Restaurent restaurent) throws RestaurentNotFoundException {
		return restaurentService.updateRestaurent(restaurent);
	}

	@GetMapping("/getRestaurentById/{restaurentId}")
	public Restaurent getRestaurentById(@PathVariable int restaurentId) throws RestaurentNotFoundException {
		return restaurentService.getRestaurentById(restaurentId);
	}

	@GetMapping("/getAllRestaurents")
	public List<Restaurent> getAllRestaurents() throws RestaurentNotFoundException {
		return restaurentService.getAllRestaurents();
	}

	@DeleteMapping("/deleteRestaurent/{restaurentId}")
	public String deleteRestaurent(@PathVariable int restaurentId)throws RestaurentNotFoundException {
		return restaurentService.deleteRestaurentById(restaurentId);
	}
}
