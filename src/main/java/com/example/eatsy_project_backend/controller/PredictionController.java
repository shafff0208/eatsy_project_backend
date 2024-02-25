package com.example.eatsy_project_backend.controller;

import com.example.eatsy_project_backend.dto.PredictionDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/api/prediction")
public class PredictionController {

    @GetMapping("/predict")
    public String predictMeal(@RequestBody PredictionDto meal)
    {

        String results ="undefined";
        String results1 ="undefined";
        String results2 ="undefined";
        String results3 ="undefined";


        String Age = meal.getAge();
        String Gender = meal.getGender();
        String Height = meal.getHeight();
        String WeightGoal = meal.getWeightGoal();
        String CurrentWeight = meal.getCurrentWeight();
        String TargetWeight = meal.getTargetWeight();
        String ActivityLevel = meal.getActivityLevel();
        String WeightLossPace = meal.getWeightLossPace();
        String WeightGainPace = meal.getWeightGainPace();
        String DailyCalorieGoal = meal.getDailyCalorieGoal();


        String data = Age + "," + Gender + "," + Height + "," + "\"" + WeightGoal + "\"" + "," + CurrentWeight + "," + TargetWeight +  "," + "\"" + ActivityLevel + "\"" + "," + WeightLossPace + "," + WeightGainPace + "," + DailyCalorieGoal + "," + "?";
        System.out.println("Generated ARFF Data: " + data);


        try(FileWriter f = new FileWriter("./data/breakfast-unknowntest.arff", false);
            BufferedWriter b1 = new BufferedWriter(f);
            PrintWriter p = new PrintWriter(b1);) {

            p.println("@RELATION breakfast_unknowntest");
            p.println();

            p.println("@ATTRIBUTE Age REAL");
            p.println("@ATTRIBUTE Gender {Male, Female}");
            p.println("@ATTRIBUTE Height REAL");
            p.println("@ATTRIBUTE WeightGoal {\"Weight Loss\", \"Weight Gain\", \"Maintain Weight\"}");
            p.println("@ATTRIBUTE CurrentWeight REAL");
            p.println("@ATTRIBUTE TargetWeight REAL");
            p.println("@ATTRIBUTE ActivityLevel {\"No Exercise\", \"Light Exercise\", \"Moderate Exercise\", \"Hard Exercise\", \"Physical Job or Hard Exercise\", \"Professional Athlete\"}");
            p.println("@ATTRIBUTE WeightLossPace {Normal, Strict, N/A}");
            p.println("@ATTRIBUTE WeightGainPace {Normal, Strict, N/A}");
            p.println("@ATTRIBUTE DailyCalorieGoal REAL");


            p.println("@ATTRIBUTE MealPackage {\"Yogurt Parfait\", \"Peanut Butter Banana Toast\", \"Scrambled Eggs with Spinach\", \"Breakfast Burrito\"}");

            p.println();
            p.println("@DATA");
            p.println(data);

        }catch(IOException i)
        {
            i.printStackTrace();
        }


        J48 breakfast = null;
        J48 lunch = null;
        J48 dinner = null;

        try{


            breakfast = (J48)weka.core.SerializationHelper.read("./model/J48_model_breakfast.model");
            lunch = (J48)weka.core.SerializationHelper.read("./model/J48_model_lunch.model");
            dinner = (J48)weka.core.SerializationHelper.read("./model/J48_model_dinner.model");


            ConverterUtils.DataSource validate = new ConverterUtils.DataSource("./data/breakfast-unknowntest.arff");


            Instances v = validate.getDataSet();

            v.setClassIndex(v.numAttributes() - 1);

            Instance inst = v.instance(0);

            System.out.println(breakfast.classifyInstance(inst));
            System.out.println(lunch.classifyInstance(inst));
            System.out.println(dinner.classifyInstance(inst));

            if(breakfast.classifyInstance(inst) == 0.0)
                results1 = "Yogurt Parfait";
            else if(breakfast.classifyInstance(inst) == 1.0)
                results1 = "Peanut Butter Banana Toast";
            else if(breakfast.classifyInstance(inst) == 2.0)
                results1 = "Scrambled Eggs with Spinach";
            else
                results1 = "Breakfast Burrito";

            if(lunch.classifyInstance(inst) == 0.0)
                results2 = "Cottage Cheese and Veggie Bowl";
            else if(lunch.classifyInstance(inst) == 1.0)
                results2 = "Lentil Salad";
            else if(lunch.classifyInstance(inst) == 2.0)
                results2 = "Easy Chicken Salad";
            else
                results2 = "Hummus and Turkey Wrap";

            if(dinner.classifyInstance(inst) == 0.0)
                results3 = "Broccoli and Chickpea Stir-Fry";
            else if(dinner.classifyInstance(inst) == 1.0)
                results3 = "Grilled Chicken with Roasted Vegetables";
            else if(dinner.classifyInstance(inst) == 2.0)
                results3 = "Quinoa and Black Bean Bowl";
            else
                results3 = "Salmon with Sweet Potato and Asparagus";

            results = results1 + "\n" + results2 + "\n" + results3;


        }catch(Exception ex)
        {
            throw new RuntimeException(ex);
        }

        return results;


    }




}
