package com.example.eatsy_project_backend.service;

import com.example.eatsy_project_backend.model.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MealpackageServiceInterface {

    public List<Mealpackage> getAllMealpackages();

    public Mealpackage getMealpackageByMealpackageId(int id);

    public Mealpackage addMealpackage(Mealpackage p);

    public Mealpackage updateMealpackage(Mealpackage p);

    public void deleteMealpackageById(int id);


}