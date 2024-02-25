package com.example.eatsy_project_backend.repository;

import com.example.eatsy_project_backend.model.Mealpackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MealpackageRepo extends JpaRepository<Mealpackage, Integer> {

    Optional<Mealpackage> findByPackageNo(String packageNo);

    Optional<String> deleteByPackageNo(String packageNo);

}