package com.example.eatsy_project_backend.service;


import com.example.eatsy_project_backend.model.Mealpackage;
import com.example.eatsy_project_backend.model.Ingredient;
import com.example.eatsy_project_backend.repository.MealpackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class MealpackageServiceImp implements MealpackageServiceInterface {

    @Autowired
    MealpackageRepo mealpackageRepo;

    public List<Mealpackage> getAllMealpackages() {
        List<Mealpackage> result = new ArrayList<>();
        Iterable<Mealpackage> it = mealpackageRepo.findAll();
        it.forEach(result::add);
        return result;

        // return null;
    }

    public Mealpackage getMealpackageByMealpackageId(int id) {
        return mealpackageRepo.findById(id).get();
    }


    public Mealpackage addMealpackage(Mealpackage p) {
        return mealpackageRepo.save(p);

    }

    public Mealpackage updateMealpackage(Mealpackage p) {

        Mealpackage existingMealpackage = mealpackageRepo.findByPackageNo(p.getPackageNo()).orElse(null);
        existingMealpackage.setQuantity(p.getQuantity());
        existingMealpackage.setPrice(p.getPrice());
        existingMealpackage.setPackageName(p.getPackageName());
        existingMealpackage.setDescription(p.getDescription());
        return mealpackageRepo.save(existingMealpackage);
    }


    public void deleteMealpackageById(int id) {
        mealpackageRepo.deleteById(id);
    }


}



