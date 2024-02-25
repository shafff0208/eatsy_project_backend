package com.example.eatsy_project_backend.controller;

import com.example.eatsy_project_backend.model.IngredientSupplier;
import com.example.eatsy_project_backend.service.IngredientSupplierServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/IngredientSuppliers")
public class IngredientSupplierController {

    @Autowired
    IngredientSupplierServiceInterface supplierservice;


    @GetMapping("/allIngredientSuppliers")
    public List<IngredientSupplier> findAllSuppliers() {
        return supplierservice.getAllSuppliers();


    }

    @GetMapping("/getIngredientSupplierById/{id}")
    public IngredientSupplier findSupplierById(@PathVariable(value = "id") int supplierid) {
        return supplierservice.getSupplierBySupplierId(supplierid);


    }

    @PostMapping("/addIngredientSupplier")
    public IngredientSupplier findSupplierBySupplierNo(@RequestBody IngredientSupplier supplier) {
        return supplierservice.addSupplier(supplier);

    }

    @PutMapping("/updateIngredientSupplier")
    public IngredientSupplier updateSupplier(@RequestBody IngredientSupplier supplier) {
        return supplierservice.updateSupplier(supplier);
    }


    @DeleteMapping("/deleteIngredientSupplierById/{id}")
    public void deleteSupplier(@PathVariable int id) {
        supplierservice.deleteSupplierById(id);

    }


}
