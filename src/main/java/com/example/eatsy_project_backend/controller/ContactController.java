package com.example.eatsy_project_backend.controller;

import com.example.eatsy_project_backend.model.Contact;
import com.example.eatsy_project_backend.model.Customer;
import org.springframework.web.bind.annotation.*;
import com.example.eatsy_project_backend.service.ContactServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")

public class ContactController {


    @Autowired
    ContactServiceInterface contactService;

    @GetMapping("/allContacts")
    public List<Contact> findAllContacts() {
        return contactService.getAllContacts();
    }

    @PostMapping("/addContact/{customerno}")
    public Contact addContact(@RequestBody Contact c, @PathVariable(value = "customerno") String customerno) {
        return contactService.addContact(c, customerno);
    }

    @GetMapping("/findCustomerByEmailContact/{email}")
    public Customer findCustomerByEmailContact(@PathVariable(value = "email") String email) {
        return contactService.getCustomerByEmailContact(email);
    }



}



