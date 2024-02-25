package com.example.eatsy_project_backend.controller;

import com.example.eatsy_project_backend.model.*;
import com.example.eatsy_project_backend.service.MealpackageServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("/api/mealpackages")

public class MealpackageController {

    @Autowired
    MealpackageServiceInterface mealpackageservice;


    @GetMapping("/allmealpackages")
    public List<Mealpackage> findAllMealpackages() {
        return mealpackageservice.getAllMealpackages();


    }

    @GetMapping("/getMealpackageById/{id}")
    public Mealpackage findMealpackageById(@PathVariable(value = "id") int mealpackageid) {
        return mealpackageservice.getMealpackageByMealpackageId(mealpackageid);


    }


    @PostMapping("/addMealpackage")
    public Mealpackage findMealpackageByPackageNo(@RequestBody Mealpackage mealpackage) {
        return mealpackageservice.addMealpackage(mealpackage);

    }

    @PutMapping("/updateMealpackage")
    public Mealpackage updateMealpackage(@RequestBody Mealpackage mealpackage) {
        return mealpackageservice.updateMealpackage(mealpackage);
    }


    @DeleteMapping("/deleteMealpackageById/{id}")
    public void deleteMealpackage(@PathVariable int id) {
        mealpackageservice.deleteMealpackageById(id);

    }


}
