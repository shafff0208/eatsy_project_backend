package com.example.eatsy_project_backend.service;


import com.example.eatsy_project_backend.model.Ingredient;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface IngredientServiceInterface {

    public List<Ingredient> getAllIngredients();

    public Ingredient getIngredientByIngredientId(int id);

    public Ingredient addIngredient(Ingredient i);

    public Ingredient updateIngredient(Ingredient i);

    public void deleteIngredientById(int id);


}
