package com.aktansanhal.reciperestdemo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;



@Entity
@Table(name="food")
@Data
public class Food {
	
	@Id
	Long id;
	
	String name;
	
	String description;
	
	String time;
	
	String typeOfMeal;
	

	//List<Ingredient> ingredient;


	
	
	
}
