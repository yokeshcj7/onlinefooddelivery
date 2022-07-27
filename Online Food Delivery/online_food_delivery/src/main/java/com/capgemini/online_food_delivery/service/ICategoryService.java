package com.capgemini.online_food_delivery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.online_food_delivery.entity.Category;
import com.capgemini.online_food_delivery.repository.ICategoryRepository;

@Service
public class ICategoryService {
	@Autowired
	ICategoryRepository CategoryRepository;

	public Category addCategory(Category category) {
		return CategoryRepository.save(category);
	}

	public Category updateCategory(Category category) {
		Optional<Category> container = CategoryRepository.findById(category.getId());
		if (container.isPresent()) {
			Category result = container.get();
			result.setId(category.getId());
			result.setName(category.getName());
			return CategoryRepository.save(result);
		}
		return null;
	}

	public Category removeCategory(int categoryId) {
		Optional<Category> container = CategoryRepository.findById(categoryId);
		if (container.isPresent()) {
			Category result = container.get();
			CategoryRepository.delete(result);
			return result;
		}
		return null;
	}

	public Category viewCategory(int categoryId) {
		Optional<Category> container = CategoryRepository.findById(categoryId);
		if (container.isPresent()) {
			return container.get();
		}
		return null;
	}

	public List<Category> viewAllCategory() {
		List<Category> result = new ArrayList<Category>();
		result = CategoryRepository.findAll();
		return result;
	}
}
