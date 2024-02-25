package com.example.eatsy_project_backend.service;


import com.example.eatsy_project_backend.model.Contact;
import com.example.eatsy_project_backend.model.Customer;
import com.example.eatsy_project_backend.model.Order;
import com.example.eatsy_project_backend.model.Payment;
import com.example.eatsy_project_backend.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class CustomerServiceImp implements CustomerServiceInterface {

    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> getAllCustomers() {
        List<Customer> result = new ArrayList<>();
        Iterable<Customer> it = customerRepo.findAll();
        it.forEach(result::add);
        return result;

        // return null;
    }

    public Customer getCustomerBycusid(int id) {
        return customerRepo.findById(id).get();
    }

    public Optional<Customer> getCustomerByCustomerNo(String customerNo) {
        return customerRepo.findByCustomerNo(customerNo);
    }


    public Customer updateCustomer(Customer c) {

        Customer existingCustomer = customerRepo.findByCustomerNo(c.getCustomerNo()).orElse(null);
        existingCustomer.setFirstName(c.getFirstName());
        existingCustomer.setLastName(c.getLastName());
        existingCustomer.setCity(c.getCity());
        existingCustomer.setState(c.getState());
        existingCustomer.setZipCode(c.getZipCode());
        return customerRepo.save(existingCustomer);
    }

    public Optional<String> removeCustomerByCustomerNo(String customerNo) {
        Optional<Customer> existingCustomer = customerRepo.findByCustomerNo(customerNo);

        if (existingCustomer.isPresent()) {
            customerRepo.deleteByCustomerNo(customerNo);
            return Optional.of(customerNo + " Delete is successful");
        } else {
            return Optional.of("Fail to delete");
        }

    }

    public void deleteCustomerById(int id) {
        customerRepo.deleteById(id);
    }


    @Override
    public Set<Contact> getAllContactsByCustomer(String customerno) {
        Optional<Customer> s = customerRepo.findByCustomerNo(customerno);
        Customer s1 = s.get();

        return s1.getContacts();
    }


    @Override
    public Set<Order> getAllOrdersByCustomer(String orderno) {
        Optional<Customer> s = customerRepo.findByCustomerNo(orderno);
        Customer s1 = s.get();

        return s1.getOrders();
    }


    @Override
    public Set<Payment> getAllPaymentsByCustomer(String paymentno) {
        Optional<Customer> s = customerRepo.findByCustomerNo(paymentno);
        Customer s1 = s.get();

        return s1.getPayments();
    }


    @Override
    public Customer addCustomer(Customer c) {
        return customerRepo.save(c);
    }

    @Override
    public Customer getCustomerById(int id) {

        Optional<Customer> c = customerRepo.findById(id);
        return c.get();
    }


}

