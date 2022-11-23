package com.aktansanhal.reciperestdemo.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="ingredient")
@Data
public class Ingredient {
	
	@Id
	Long id;
	String name;
	Double amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "food_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	Food food;

}
