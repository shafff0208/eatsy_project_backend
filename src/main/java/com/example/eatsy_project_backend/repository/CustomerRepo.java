package com.example.eatsy_project_backend.repository;

import com.example.eatsy_project_backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByCustomerNo(String customerNo);

    Optional<String> deleteByCustomerNo(String customerNo);

}
