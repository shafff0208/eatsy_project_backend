package com.example.eatsy_project_backend.service;

import com.example.eatsy_project_backend.model.Contact;
import com.example.eatsy_project_backend.model.Customer;
import com.example.eatsy_project_backend.repository.ContactRepo;
import com.example.eatsy_project_backend.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactServiceImp implements ContactServiceInterface {

    @Autowired
    ContactRepo contactRepo;

    @Autowired
    CustomerRepo customerrepo;


    @Override
    public List<Contact> getAllContacts() {
        return contactRepo.findAll();
    }

    @Override
    public Contact addContact(Contact s, String c) {
        Contact c1 = null;

        Optional<Customer> existingcustomer = customerrepo.findByCustomerNo(c);


        if (existingcustomer.isPresent()) {

            s.setCustomer(existingcustomer.get());
            c1 = contactRepo.save(s);
        }


        return c1;
    }

    @Override
    public Customer getCustomerByEmailContact(String c) {
        return contactRepo.findContactByEmail(c).getCustomer();
    }

    @Override
    public Contact updateContact(String email, String phone) {
        return null;
    }

    @Override
    public Contact addContact(Contact c) {
        return contactRepo.save(c);
    }

    @Override
    public Contact getContactByCustId(int id) {
        return contactRepo.findContactByCustomer_Id(id);
    }


}
