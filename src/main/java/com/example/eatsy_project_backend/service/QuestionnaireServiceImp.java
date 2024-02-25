package com.example.eatsy_project_backend.service;
import com.example.eatsy_project_backend.dto.QuestionnaireDto;
import com.example.eatsy_project_backend.model.Customer;
import com.example.eatsy_project_backend.model.Questionnaire;
import com.example.eatsy_project_backend.repository.CustomerRepo;
import com.example.eatsy_project_backend.repository.QuestionnaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireServiceImp implements QuestionnaireServiceInterface {


    @Autowired
    private QuestionnaireRepo questionnaireRepo;


    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Questionnaire saveQuestionnaire(QuestionnaireDto questionnaireDto) {
        Customer customer = customerRepo.findById(questionnaireDto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setCustomer(customer);
        questionnaire.setAge(questionnaireDto.getAge());
        questionnaire.setGender(questionnaireDto.getGender());
        questionnaire.setHeight(questionnaireDto.getHeight());
        questionnaire.setWeightGoal(questionnaireDto.getWeightGoal());
        questionnaire.setCurrentWeight(questionnaireDto.getCurrentWeight());
        questionnaire.setTargetWeight(questionnaireDto.getTargetWeight());
        questionnaire.setActivityLevel(questionnaireDto.getActivityLevel());
        questionnaire.setWeightLossPace(questionnaireDto.getWeightLossPace());
        questionnaire.setWeightGainPace(questionnaireDto.getWeightGainPace());
        questionnaire.setDailyCalorieGoal(questionnaireDto.getDailyCalorieGoal());


        return questionnaireRepo.save(questionnaire);
    }


}