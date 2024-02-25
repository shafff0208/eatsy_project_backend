package com.example.eatsy_project_backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PredictionDto {

    private String age;
    private String gender;
    private String height;
    private String weightGoal;
    private String currentWeight;
    private String targetWeight;
    private String activityLevel;
    private String weightLossPace;
    private String weightGainPace;
    private String dailyCalorieGoal;

}
