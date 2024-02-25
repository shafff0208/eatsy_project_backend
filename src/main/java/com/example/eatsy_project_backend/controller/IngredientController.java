package com.example.eatsy_project_backend.controller;


import com.example.eatsy_project_backend.model.Ingredient;
import com.example.eatsy_project_backend.service.IngredientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/ingredients")

public class IngredientController {

    @Autowired
    IngredientServiceInterface ingredientservice;


    @GetMapping("/allIngredients")
    public List<Ingredient> findAllIngredients() {
        return ingredientservice.getAllIngredients();


    }

    @GetMapping("/getIngredientById/{id}")
    public Ingredient findIngredientById(@PathVariable(value = "id") int ingredientid) {
        return ingredientservice.getIngredientByIngredientId(ingredientid);


    }


    @PostMapping("/addIngredient")
    public Ingredient findIngredientByIngredientNo(@RequestBody Ingredient ingredient) {
        return ingredientservice.addIngredient(ingredient);

    }

    @PutMapping("/updateIngredient")
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient) {
        return ingredientservice.updateIngredient(ingredient);
    }


    @DeleteMapping("/deleteIngredientById/{id}")
    public void deleteIngredient(@PathVariable int id) {
        ingredientservice.deleteIngredientById(id);

    }


}

