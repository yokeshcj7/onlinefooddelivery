package com.capgemini.online_food_delivery.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.online_food_delivery.entity.Restaurent;
import com.capgemini.online_food_delivery.exception.RestaurentNotFoundException;
import com.capgemini.online_food_delivery.repository.IRestaurentRepository;

@Service
public class RestaurentService {
	@Autowired
	IRestaurentRepository restaurentRepository;

	public Restaurent addRestaurent(Restaurent restaurent) {
		return restaurentRepository.save(restaurent);
	}


	public Restaurent updateRestaurent(Restaurent restaurent) throws RestaurentNotFoundException {
		Optional<Restaurent> container = restaurentRepository.findById(restaurent.getId());
		if (container.isPresent()) {
			Restaurent result = container.get();
			result.setContactNumber(restaurent.getContactNumber());
			result.setManagerName(restaurent.getManagerName());
			result.setRestaurentName(restaurent.getRestaurentName());
			result.setRestaurentAddress(restaurent.getRestaurentAddress());
			return restaurentRepository.save(result);
		}
		throw new RestaurentNotFoundException("Restaurent not found");
	}

	public String deleteRestaurentById(int restaurentId) throws RestaurentNotFoundException {

		Optional<Restaurent> container = restaurentRepository.findById(restaurentId);
		if (container.isPresent()) {
			restaurentRepository.deleteById(restaurentId);
			return "Restaurent deleted successfully";
		}
		throw new RestaurentNotFoundException("Restaurent not found");
	}

	public Restaurent getRestaurentById(int restaurentId) throws RestaurentNotFoundException {

		Optional<Restaurent> container = restaurentRepository.findById(restaurentId);
		if (container.isPresent()) {
			System.out.println(container.get().getId());
			return container.get();
		}
		throw new RestaurentNotFoundException("Restaurent not found");
	}

	public List<Restaurent> getAllRestaurents() throws RestaurentNotFoundException {
		List<Restaurent> restaurents = restaurentRepository.findAll();

		if (restaurents.isEmpty()) {
			throw new RestaurentNotFoundException("No Restaurents found");
		}
		return restaurents;

	}

}
