package com.example.eatsy_project_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "questionnaire")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Questionnaire {
    @Id
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "height")
    private Integer height;

    @Column(name = "weight_goal", length = 45)
    private String weightGoal;

    @Column(name = "current_weight")
    private Integer currentWeight;

    @Column(name = "target_weight")
    private Integer targetWeight;

    @Column(name = "activity_level", length = 45)
    private String activityLevel;

    @Column(name = "weight_loss_pace", length = 45)
    private String weightLossPace;

    @Column(name = "weight_gain_pace", length = 45)
    private String weightGainPace;

    @Column(name = "daily_calorie_goal")
    private Integer dailyCalorieGoal;

}