package com.aktansanhal.reciperestdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aktansanhal.reciperestdemo.entities.Food;
import com.aktansanhal.reciperestdemo.repos.FoodRepository;

@Service
public class FoodService {
	
	private FoodRepository foodRepository;

	public FoodService(FoodRepository foodRepository) {
		super();
		this.foodRepository = foodRepository;
	}

	public List<Food> findAll() {
		return foodRepository.findAll();
	}

	public Food findById(Long foodId) {
		// TODO Auto-generated method stub
		return foodRepository.findById(foodId).orElse(null);
	}

	public Food updateFood(Long foodId, Food food) {

		Optional<Food> foundFood = foodRepository.findById(foodId);
		if(foundFood.isPresent()) {
			Food updateFood = foundFood.get();
			updateFood.setName(food.getName());
			updateFood.setDescription(food.getDescription());
			updateFood.setTime(food.getTime());
			updateFood.setTypeOfMeal(food.getTypeOfMeal());
			
			return foodRepository.save(updateFood);
		}else {
			return null;
		}

	}

	public Food createFood(Food food) {
		
		return foodRepository.save(food);
	}

	public void deleteOneFood(Long foodId) {
		foodRepository.deleteById(foodId);
	}
	
	
}
