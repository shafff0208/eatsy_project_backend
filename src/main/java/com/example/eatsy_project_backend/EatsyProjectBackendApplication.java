package com.example.eatsy_project_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class EatsyProjectBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EatsyProjectBackendApplication.class, args);
    }

}
