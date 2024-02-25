package com.example.eatsy_project_backend.service;

import com.example.eatsy_project_backend.model.IngredientSupplier;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IngredientSupplierServiceInterface {

    public List<IngredientSupplier> getAllSuppliers();

    public IngredientSupplier getSupplierBySupplierId(int id);

    public IngredientSupplier addSupplier(IngredientSupplier s);

    public IngredientSupplier updateSupplier(IngredientSupplier s);

    public void deleteSupplierById(int id);


}
