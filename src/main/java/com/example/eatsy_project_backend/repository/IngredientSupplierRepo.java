package com.example.eatsy_project_backend.repository;

import com.example.eatsy_project_backend.model.IngredientSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IngredientSupplierRepo extends JpaRepository<IngredientSupplier, Integer> {

    Optional<IngredientSupplier> findBySupplierNo(String supplierNo);

    Optional<String> deleteBySupplierNo(String supplierNo);


}
