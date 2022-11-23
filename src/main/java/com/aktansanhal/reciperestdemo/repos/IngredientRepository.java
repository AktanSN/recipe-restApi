package com.aktansanhal.reciperestdemo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aktansanhal.reciperestdemo.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
