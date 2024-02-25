package com.example.eatsy_project_backend.repository;

import com.example.eatsy_project_backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

    Optional<Order> findByOrderNo(String orderNo);

    Optional<String> deleteByOrderNo(String orderNo);

}