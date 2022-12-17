package com.restapi.project.surveyModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private String id;
    private String description;
    private List<String> options;
    private String rightAnswer;
   @Override
    public String toString(){
        return "Survey [id=" + id + ", description=" + description + ", options=" + options + ", rightAnswer=" + rightAnswer
                + "]";
    }
}
