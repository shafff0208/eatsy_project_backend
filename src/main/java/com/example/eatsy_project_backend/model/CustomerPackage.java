package com.example.eatsy_project_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Entity
@Table(name = "customer_package")
public class CustomerPackage {
    @EmbeddedId
    private CustomerPackageId id;

    @MapsId("customerId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customerId;

    @MapsId("packageId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "package_id", nullable = false)
    private Mealpackage packageId;

    @Column(name = "date")
    private LocalDate date;

    public CustomerPackage() {


    }

    public CustomerPackage(CustomerPackageId id, Customer customerId, Mealpackage packageId) {
        this.id = id;
        this.customerId = customerId;
        this.packageId = packageId;

    }

}


