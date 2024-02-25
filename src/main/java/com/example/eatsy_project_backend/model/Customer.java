package com.example.eatsy_project_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "last_name", length = 45)
    private String lastName;

    @Column(name = "customer_no", length = 20)
    private String customerNo;

    @Column(name = "street_address", length = 100)
    private String streetAddress;

    @Column(name = "city", length = 45)
    private String city;

    @Column(name = "state", length = 45)
    private String state;

    @Column(name = "zip_code")
    private Integer zipCode;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Contact> contacts = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "customer_package",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "package_id"))
    @JsonIgnore
    private Set<Mealpackage> mealpackages = new LinkedHashSet<>();

    @OneToOne(mappedBy = "customer")
    @JsonIgnore
    private Login login;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Payment> payments = new LinkedHashSet<>();

    @OneToOne(mappedBy = "customer")
    @JsonIgnore
    private Questionnaire questionnaire;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", customerNo='" + customerNo + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }


    public Customer(Integer id, String firstName, String lastName, String customerNo, String streetAddress, String city, String state, Integer zipCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerNo = customerNo;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }



}