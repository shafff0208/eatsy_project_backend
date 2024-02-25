package com.example.eatsy_project_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ingredient_supplier")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class IngredientSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "last_name", length = 45)
    private String lastName;

    @Column(name = "supplier_no", length = 20)
    private String supplierNo;

    @OneToMany(mappedBy = "supplier")
    @JsonIgnore
    private Set<Ingredient> ingredients = new LinkedHashSet<>();


    @Override
    public String toString() {
        return "IngredientSupplier{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", supplierNo='" + supplierNo + '\'' +
                '}';
    }
}