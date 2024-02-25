package com.example.eatsy_project_backend.repository;


import com.example.eatsy_project_backend.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepo extends JpaRepository<Ingredient, Integer> {


    Optional<Ingredient> findByIngredientNo(String ingredientNo);

    void deleteByIngredientNo(String ingredientNo);

}

