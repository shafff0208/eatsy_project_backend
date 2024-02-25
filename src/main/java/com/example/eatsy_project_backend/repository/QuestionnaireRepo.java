package com.example.eatsy_project_backend.repository;

import com.example.eatsy_project_backend.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories
@Repository
public interface QuestionnaireRepo extends JpaRepository<Questionnaire, Integer> {

}