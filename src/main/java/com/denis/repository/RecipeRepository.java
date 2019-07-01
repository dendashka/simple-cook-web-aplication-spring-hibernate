package com.denis.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.denis.entity.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer>{

	List<Recipe> findByTag(String tag);
}
