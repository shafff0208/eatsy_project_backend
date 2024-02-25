
package com.example.eatsy_project_backend.service;

import com.example.eatsy_project_backend.dto.LoginDto;
import com.example.eatsy_project_backend.dto.LoginRegistrationWrapper;
import com.example.eatsy_project_backend.model.Customer;
import com.example.eatsy_project_backend.response.LoginResponse;

public interface LoginServiceInterface {

    Customer addLoginCustomer(LoginRegistrationWrapper reg);


    public void addLogin(com.example.eatsy_project_backend.model.Login l);

    LoginResponse loginCustomer(LoginDto logininfo);
}
