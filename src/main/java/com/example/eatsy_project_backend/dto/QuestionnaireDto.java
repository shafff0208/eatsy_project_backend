package com.example.eatsy_project_backend.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class QuestionnaireDto {

    private Integer customerId;
    private Integer age;
    private String gender;
    private Integer height;
    private String weightGoal;
    private Integer currentWeight;
    private Integer targetWeight;
    private String activityLevel;
    private String weightLossPace;
    private String weightGainPace;
    private Integer dailyCalorieGoal;

}
