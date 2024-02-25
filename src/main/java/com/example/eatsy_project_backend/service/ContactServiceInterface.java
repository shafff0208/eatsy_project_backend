package com.example.eatsy_project_backend.service;


import com.example.eatsy_project_backend.model.Contact;
import com.example.eatsy_project_backend.model.Customer;

import java.util.List;

public interface ContactServiceInterface {

    public List<Contact> getAllContacts();

    public Contact addContact(Contact s, String c);

    public Customer getCustomerByEmailContact(String c);

    public Contact updateContact(String email, String phone);

    public Contact addContact(Contact c);

    public Contact getContactByCustId(int id);


}

