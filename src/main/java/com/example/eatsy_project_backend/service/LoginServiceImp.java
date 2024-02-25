
package com.example.eatsy_project_backend.service;

import com.example.eatsy_project_backend.dto.LoginDto;
import com.example.eatsy_project_backend.dto.LoginRegistrationWrapper;
import com.example.eatsy_project_backend.model.Customer;
import com.example.eatsy_project_backend.model.Contact;
import com.example.eatsy_project_backend.model.Login;
import com.example.eatsy_project_backend.repository.LoginRepo;
import com.example.eatsy_project_backend.response.LoginResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional


public class LoginServiceImp implements LoginServiceInterface {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LoginRepo loginRepo;


    @Autowired
    private CustomerServiceInterface customerServiceInt;

    @Autowired
    private ContactServiceInterface contactServiceInt;


    @Override
    public Customer addLoginCustomer(LoginRegistrationWrapper reg) {

        Customer c1 = customerServiceInt.addCustomer(reg.getCust());  //persist

        Login a = reg.getLogin();

        a.setPassword(this.passwordEncoder.encode(a.getPassword()));

        a.setCustomer(c1);

        this.addLogin(a);  //persist

        Contact c = reg.getCont();

        c.setCustomer(c1);

        contactServiceInt.addContact(c); //persist

        return c1;
    }

    @Override
    public void addLogin(Login l) {
        loginRepo.save(l);
    }


    @Override
    public LoginResponse loginCustomer(LoginDto logininfo) {
        Login logincheck = loginRepo.findByEmail(logininfo.getEmail());
        System.out.println(logininfo.getEmail());
        if (logincheck != null) {

            String password = logininfo.getPassword();
            String encodedPassword = logincheck.getPassword();

            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Login> login = loginRepo.findOneByEmailAndPassword(logininfo.getEmail(), encodedPassword);

                if (login.isPresent()) {
                    return new LoginResponse("Login Success", true);

                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Password Not Match", false);
            }

        } else {
            return new LoginResponse("Email is not valid", false);
        }



    }

}




