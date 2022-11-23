package com.aktansanhal.reciperestdemo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aktansanhal.reciperestdemo.entities.Food;

public interface FoodRepository extends JpaRepository<Food,Long> {

}
