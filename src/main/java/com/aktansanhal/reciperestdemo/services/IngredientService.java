package com.aktansanhal.reciperestdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aktansanhal.reciperestdemo.entities.Food;
import com.aktansanhal.reciperestdemo.entities.Ingredient;
import com.aktansanhal.reciperestdemo.repos.IngredientRepository;

@Service
public class IngredientService {
	
	private IngredientRepository ingredientRepository;

	public IngredientService(IngredientRepository ingredientRepository) {
		super();
		this.ingredientRepository = ingredientRepository;
	}

	public List<Ingredient> findAll() {
		return ingredientRepository.findAll();
	}

	public Ingredient findById(Long ingredientId) {
		
		return ingredientRepository.findById(ingredientId).orElse(null);
	}

	public Ingredient updateIngredient(Long ingredientId, Ingredient ingredient) {
		Optional<Ingredient> foundIngredient = ingredientRepository.findById(ingredientId);
		
		if(foundIngredient.isPresent()) {
			Ingredient newIngredient = foundIngredient.get();
			newIngredient.setFood(ingredient.getFood());
			newIngredient.setAmount(ingredient.getAmount());
			newIngredient.setName(ingredient.getName());
			
			return ingredientRepository.save(newIngredient);
		}
		return null;
	}

	public Ingredient createIngredient(Ingredient ingredient) {
		
		return ingredientRepository.save(ingredient);
	}

	public void deleteOneIngredient(Long ingredientId) {
		ingredientRepository.deleteById(ingredientId);
		
	}
	
	

}
