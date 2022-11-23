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
import com.aktansanhal.reciperestdemo.entities.Ingredient;
import com.aktansanhal.reciperestdemo.services.IngredientService;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

	private IngredientService ingredientService;

	public IngredientController(IngredientService ingredientService) {
		super();
		this.ingredientService = ingredientService;
	}
	
	@GetMapping
	public List<Ingredient> getAllIngredients(){
		return ingredientService.findAll();
	}
	
	@GetMapping("/{ingredientId}")
	public Ingredient getOneIngredient(@PathVariable Long ingredientId) {
		return ingredientService.findById(ingredientId);
	}
	
	@PutMapping("/{ingredientId}")
	public Ingredient updateIngredient(@PathVariable Long ingredientId,@RequestBody Ingredient ingredient) {
		return ingredientService.updateIngredient(ingredientId,ingredient);
	}
	
	@PostMapping
	public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
		return ingredientService.createIngredient(ingredient);
	}
	
	@DeleteMapping("/{ingredientId}")
	public void deleteOneIngredient(@PathVariable Long IngredientId) {
		ingredientService.deleteOneIngredient(IngredientId);
	}
	
	
}
