package com.example.eatsy_project_backend.dto;

import com.example.eatsy_project_backend.model.Contact;
import com.example.eatsy_project_backend.model.Customer;
import com.example.eatsy_project_backend.model.Login;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class LoginRegistrationWrapper {

    private Customer cust;
    private Contact cont;
    private Login login;

}
