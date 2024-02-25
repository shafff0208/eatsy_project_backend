package com.example.eatsy_project_backend.controller;


import com.example.eatsy_project_backend.dto.QuestionnaireDto;
import com.example.eatsy_project_backend.model.Questionnaire;
import com.example.eatsy_project_backend.service.QuestionnaireServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questionnaire")

public class QuestionnaireController {



        @Autowired
        private QuestionnaireServiceInterface questionnaireServiceInterface;

        @PostMapping("/saveQuestionnaire")
        public ResponseEntity<Questionnaire> saveQuestionnaire(@RequestBody QuestionnaireDto questionnaireDto) {
            Questionnaire savedQuestionnaire = questionnaireServiceInterface.saveQuestionnaire(questionnaireDto);
            return ResponseEntity.ok(savedQuestionnaire);
        }


}
