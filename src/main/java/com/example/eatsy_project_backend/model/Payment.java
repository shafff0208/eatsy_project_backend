package com.example.eatsy_project_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "payment")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private Integer id;

    @Column(name = "payment_no", length = 20)
    private String paymentNo;

    @Column(name = "payment_mode", length = 45)
    private String paymentMode;

    @Column(name = "amount", precision = 5, scale = 2)
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "payment")
    @JsonIgnore
    private Set<Order> orders = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentNo='" + paymentNo + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                ", amount=" + amount +
                '}';
    }
}