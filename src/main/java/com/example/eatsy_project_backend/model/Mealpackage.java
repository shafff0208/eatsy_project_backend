package com.example.eatsy_project_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "mealpackage")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Mealpackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id", nullable = false)
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price", precision = 5, scale = 2)
    private BigDecimal price;

    @Column(name = "package_name", length = 45)
    private String packageName;

    @Column(name = "package_no", length = 20)
    private String packageNo;

    @Column(name = "description", length = 200)
    private String description;


    @ManyToMany
    @JoinTable(name = "customer_package",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    @JsonIgnore
    private Set<Customer> customers = new LinkedHashSet<>();


    @ManyToMany
    @JoinTable(name = "order_package",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    @JsonIgnore
    private Set<Order> orders = new LinkedHashSet<>();


    @ManyToMany
    @JoinTable(name = "package_ingredient",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    @JsonIgnore
    private Set<Ingredient> ingredients = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "Mealpackage{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", packageName='" + packageName + '\'' +
                ", packageNo='" + packageNo + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


/*

    @OneToMany(mappedBy = "mealpackage")
    private Set<CustomerPackage> customerPackages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "mealpackage")
    private Set<OrderPackage> orderPackages = new LinkedHashSet<>();


    @ManyToMany(mappedBy = "mealpackage")
    private Set<Ingredient> ingredients = new LinkedHashSet<>();
*/


}

