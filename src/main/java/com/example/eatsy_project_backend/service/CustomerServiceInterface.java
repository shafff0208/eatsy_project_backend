package com.example.eatsy_project_backend.service;


import com.example.eatsy_project_backend.model.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CustomerServiceInterface {

    public List<Customer> getAllCustomers();

    public Customer getCustomerBycusid(int id);

    public Optional<Customer> getCustomerByCustomerNo(String customerNo);

    public Customer updateCustomer(Customer c);

    public void deleteCustomerById(int id);

    public Optional<String> removeCustomerByCustomerNo(String customerNo);

    public Set<Contact> getAllContactsByCustomer(String customerno);

    public Set<Order> getAllOrdersByCustomer(String customerno);

    public Set<Payment> getAllPaymentsByCustomer(String customerno);

    public Customer addCustomer(Customer c);


    public Customer getCustomerById(int id);


}