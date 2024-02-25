package com.example.eatsy_project_backend.controller;

import com.example.eatsy_project_backend.model.Contact;
import com.example.eatsy_project_backend.model.Customer;
import com.example.eatsy_project_backend.service.ContactServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")

public class ContactController {


    @Autowired
    ContactServiceInterface contactservice;

    @GetMapping("/allContacts")
    public List<Contact> findAllContacts() {
        return contactservice.getAllContacts();
    }


    @PostMapping("/addContact/{customerno}")
    public Contact addContact(@RequestBody Contact c, @PathVariable(value = "customerno") String customerno) {
        return contactservice.addContact(c, customerno);


    }


    @GetMapping("/findCustomerByEmailContact/{email}")
    public Customer findCustomerByEmailContact(@PathVariable(value = "email") String email) {
        return contactservice.getCustomerByEmailContact(email);
    }



}



