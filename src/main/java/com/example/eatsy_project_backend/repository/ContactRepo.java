package com.example.eatsy_project_backend.repository;

import com.example.eatsy_project_backend.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer> {

    Contact findContactByEmail(String email);

    public Contact findContactByCustomer_Id(int id);


}

