
package com.example.eatsy_project_backend.controller;


import com.example.eatsy_project_backend.dto.LoginDto;
import com.example.eatsy_project_backend.dto.LoginRegistrationWrapper;
import com.example.eatsy_project_backend.model.Customer;
import com.example.eatsy_project_backend.model.Login;
import com.example.eatsy_project_backend.response.LoginResponse;
import com.example.eatsy_project_backend.service.LoginServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginServiceInterface loginService;


    @PostMapping("/save")
    public ResponseEntity<?> saveCustomerLogin(@RequestBody LoginRegistrationWrapper reg) {
        //add a new login customer
        Customer customer = loginService.addLoginCustomer(reg);

        // For demonstration, returning a simple success message with customer ID
        if (customer != null) {
            String successMessage = "Customer login created successfully with ID: " + customer.getId();
            return ResponseEntity.ok(successMessage);
        } else {
            // Handle the case where customer creation failed
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create customer login");
        }

    }



    @PostMapping("/login")
    public ResponseEntity<?> CustomerLogin(@RequestBody LoginDto logininfo) {

        LoginResponse responsedetails = loginService.loginCustomer(logininfo);
        return ResponseEntity.ok(responsedetails);

    }


}


