package com.aktansanhal.reciperestdemo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aktansanhal.reciperestdemo.entities.Food;
import com.aktansanhal.reciperestdemo.services.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {

	private FoodService foodService;

	public FoodController(FoodService foodService) {
		super();
		this.foodService = foodService;
	}
	
	
	@GetMapping
	public List<Food> getAllFoods(){
		return foodService.findAll();
	}
	
	@GetMapping("/{foodId}")
	public Food getOneFood(@PathVariable Long foodId) {
		return foodService.findById(foodId);
	}
	
	@PutMapping("/{foodId}")
	public Food updateFood(@PathVariable Long foodId,@RequestBody Food food) {
		return foodService.updateFood(foodId,food);
	}
	
	@PostMapping
	public Food createFood(@RequestBody Food food) {
		return foodService.createFood(food);
	}
	
	@DeleteMapping("/{foodId}")
	public void deleteOneFood(@PathVariable Long foodId) {
		foodService.deleteOneFood(foodId);
	}
}
