package com.example.eatsy_project_backend.service;

import com.example.eatsy_project_backend.dto.QuestionnaireDto;
import com.example.eatsy_project_backend.model.Questionnaire;
import java.util.List;

public interface QuestionnaireServiceInterface {

    Questionnaire saveQuestionnaire(QuestionnaireDto questionnaireDto);


}
