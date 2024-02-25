package com.example.eatsy_project_backend.controller;

import com.example.eatsy_project_backend.model.*;
import com.example.eatsy_project_backend.service.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/customers")

public class CustomerController {

    @Autowired
    CustomerServiceInterface cusservice;


    @GetMapping("/allcustomers")
    public List<Customer> findAllCustomers() {
        return cusservice.getAllCustomers();


    }

    @GetMapping("/getCustomerById/{id}")
    public Customer findCustomerById(@PathVariable(value = "id") int cusid) {
        return cusservice.getCustomerBycusid(cusid);


    }

    @GetMapping("/getCustomerByCustomerNo/{customerNo}")
    public Optional<Customer> findCustomerByCustomerNo(@PathVariable(value = "customerNo") String customerNo) {
        return cusservice.getCustomerByCustomerNo(customerNo);


    }


    @PostMapping("/addCustomer")
    public Customer findCustomerByCustomerNo(@RequestBody Customer customer) {
        return cusservice.addCustomer(customer);

    }

    @PutMapping("/updateCustomer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return cusservice.updateCustomer(customer);
    }


    @DeleteMapping("/deleteCustomerById/{id}")
    public void deleteCustomer(@PathVariable int id) {
        cusservice.deleteCustomerById(id);

    }

    @DeleteMapping("/removeCustomerByNo/{customerNo}")
    public Optional<String> removeCustomer(@PathVariable(value = "customerNo") String customerNo) {
        return cusservice.removeCustomerByCustomerNo(customerNo);

    }


    @GetMapping("/getAllContactsByCustomer/{customerno}")
    public Set<Contact> findAllContactsByCustomer(@PathVariable(value = "customerno") String customerno) {
        return cusservice.getAllContactsByCustomer(customerno);
    }

    @GetMapping("/getAllOrdersByCustomer/{customerno}")
    public Set<Order> findAllOrdersByCustomer(@PathVariable(value = "customerno") String customerno) {
        return cusservice.getAllOrdersByCustomer(customerno);
    }


    @GetMapping("/getAllPaymentssByCustomer/{customerno}")
    public Set<Payment> findAllPaymentsByCustomer(@PathVariable(value = "customerno") String customerno) {
        return cusservice.getAllPaymentsByCustomer(customerno);
    }



}
