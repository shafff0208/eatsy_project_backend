package com.example.eatsy_project_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@Embeddable
public class PackageIngredientId implements Serializable {
    private static final long serialVersionUID = -1859066254759330554L;
    @Column(name = "package_id", nullable = false)
    private Integer packageId;

    @Column(name = "ingredient_id", nullable = false)
    private Integer ingredientId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PackageIngredientId entity = (PackageIngredientId) o;
        return Objects.equals(this.ingredientId, entity.ingredientId) &&
                Objects.equals(this.packageId, entity.packageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientId, packageId);
    }

    public PackageIngredientId() {

    }

    public PackageIngredientId(Integer packageId, Integer ingredientId) {
        this.packageId = packageId;
        this.ingredientId = ingredientId;
    }

}







