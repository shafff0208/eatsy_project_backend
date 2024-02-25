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
@Table(name = "delivery_partner")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DeliveryPartner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partner_id", nullable = false)
    private Integer id;

    @Column(name = "partner_name", length = 45)
    private String partnerName;

    @Column(name = "vehicle_no", length = 20)
    private String vehicleNo;

    @Column(name = "partner_no", length = 20)
    private String partnerNo;

    @OneToMany(mappedBy = "partner")
    @JsonIgnore
    private Set<Order> orders = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "DeliveryPartner{" +
                "id=" + id +
                ", partnerName='" + partnerName + '\'' +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", partnerNo='" + partnerNo + '\'' +
                '}';
    }

}