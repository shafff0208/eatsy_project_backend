package com.example.eatsy_project_backend.service;

import com.example.eatsy_project_backend.model.DeliveryPartner;
import com.example.eatsy_project_backend.model.IngredientSupplier;
import com.example.eatsy_project_backend.repository.DeliveryPartnerRepo;
import com.example.eatsy_project_backend.repository.IngredientSupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class IngredientSupplierServiceImp implements IngredientSupplierServiceInterface {


    @Autowired
    IngredientSupplierRepo supplierRepo;

    public List<IngredientSupplier> getAllSuppliers() {
        List<IngredientSupplier> result = new ArrayList<>();
        Iterable<IngredientSupplier> it = supplierRepo.findAll();
        it.forEach(result::add);
        return result;

    }

    public IngredientSupplier getSupplierBySupplierId(int id) {
        return supplierRepo.findById(id).get();
    }

    public IngredientSupplier addSupplier(IngredientSupplier s) {
        return supplierRepo.save(s);

    }

    public IngredientSupplier updateSupplier(IngredientSupplier s) {

        IngredientSupplier existingIngredientSupplier = supplierRepo.findBySupplierNo(s.getSupplierNo()).orElse(null);
        existingIngredientSupplier.setFirstName(s.getFirstName());
        existingIngredientSupplier.setLastName(s.getLastName());

        return supplierRepo.save(existingIngredientSupplier);
    }


    public void deleteSupplierById(int id) {
        supplierRepo.deleteById(id);
    }


}
