package com.example.eatsy_project_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ingredient")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false)
    private Integer id;

    @Column(name = "ingredient_no", length = 20)
    private String ingredientNo;

    @Column(name = "ingredient_name", length = 45)
    private String ingredientName;

    @Column(name = "price", precision = 5, scale = 2)
    private BigDecimal price;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "expiry_duration")
    private Integer expiryDuration;

    @Column(name = "unit_in_stock")
    private Integer unitInStock;

    @Column(name = "reorder_level")
    private Integer reorderLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    @JsonIgnore
    private IngredientSupplier supplier;


    @ManyToMany
    @JoinTable(name = "package_ingredient",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "package_id"))
    @JsonIgnore
    private Set<Mealpackage> mealpackages = new LinkedHashSet<>();


    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", ingredientNo='" + ingredientNo + '\'' +
                ", ingredientName='" + ingredientName + '\'' +
                ", price=" + price +
                ", expiryDate=" + expiryDate +
                ", expiryDuration=" + expiryDuration +
                ", unitInStock=" + unitInStock +
                ", reorderLevel=" + reorderLevel +
                '}';
    }
}

