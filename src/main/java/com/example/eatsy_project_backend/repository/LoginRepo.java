
package com.example.eatsy_project_backend.repository;

import com.example.eatsy_project_backend.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface LoginRepo extends JpaRepository<Login, Integer> {

    Optional<Login> findOneByEmailAndPassword(String email, String password);

    Login findByEmail(String email);


}
