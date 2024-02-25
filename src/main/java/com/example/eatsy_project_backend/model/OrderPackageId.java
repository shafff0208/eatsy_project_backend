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
public class OrderPackageId implements Serializable {
    private static final long serialVersionUID = -8350602096867991947L;
    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "package_id", nullable = false)
    private Integer packageId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderPackageId entity = (OrderPackageId) o;
        return Objects.equals(this.orderId, entity.orderId) &&
                Objects.equals(this.packageId, entity.packageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, packageId);
    }

}