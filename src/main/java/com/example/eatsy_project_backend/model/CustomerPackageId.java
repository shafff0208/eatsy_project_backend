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
public class CustomerPackageId implements Serializable {
    private static final long serialVersionUID = -6961320840507552137L;
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @Column(name = "package_id", nullable = false)
    private Integer packageId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CustomerPackageId entity = (CustomerPackageId) o;
        return Objects.equals(this.customerId, entity.customerId) &&
                Objects.equals(this.packageId, entity.packageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, packageId);
    }


    public CustomerPackageId() {

    }

    public CustomerPackageId(Integer customerId, Integer packageId) {
        this.customerId = customerId;
        this.packageId = packageId;
    }

}








