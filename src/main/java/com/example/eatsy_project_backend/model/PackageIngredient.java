package com.example.eatsy_project_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Entity
@Table(name = "package_ingredient")
public class PackageIngredient {
    @EmbeddedId
    private PackageIngredientId id;

    @MapsId("packageId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "package_id", nullable = false)
    private Mealpackage packageId;

    @MapsId("ingredientId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredientId;


    public PackageIngredient() {


    }

    public PackageIngredient(PackageIngredientId id, Mealpackage packageId, Ingredient ingredientId) {
        this.id = id;
        this.packageId = packageId;
        this.ingredientId = ingredientId;

    }

}


