package com.example.eatsy_project_backend.service;

import com.example.eatsy_project_backend.model.Ingredient;
import com.example.eatsy_project_backend.repository.IngredientRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class IngredientServiceImp implements IngredientServiceInterface {

    @Autowired
    IngredientRepo ingredientRepo;

    public List<Ingredient> getAllIngredients() {
        List<Ingredient> result = new ArrayList<>();
        Iterable<Ingredient> it = ingredientRepo.findAll();
        it.forEach(result::add);
        return result;

    }

    public Ingredient getIngredientByIngredientId(int id) {
        return ingredientRepo.findById(id).get();
    }


    public Ingredient addIngredient(Ingredient i) {
        return ingredientRepo.save(i);

    }

    public Ingredient updateIngredient(Ingredient i) {

        Ingredient existingIngredient = ingredientRepo.findByIngredientNo(i.getIngredientNo()).orElse(null);
        existingIngredient.setIngredientName(i.getIngredientName());
        existingIngredient.setPrice(i.getPrice());
        existingIngredient.setExpiryDate(i.getExpiryDate());
        existingIngredient.setExpiryDuration(i.getExpiryDuration());
        existingIngredient.setUnitInStock(i.getUnitInStock());
        existingIngredient.setReorderLevel(i.getReorderLevel());

        return ingredientRepo.save(existingIngredient);
    }


    public void deleteIngredientById(int id) {
        ingredientRepo.deleteById(id);
    }


}
