package com.restapi.project.surveyModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Survey {
    private String id;
    private String title;
    private String description;
    private List<Question> questions;

    @Override
    public String toString() {
        return "Survey [id=" + id + ", title=" + title + ", description=" + description + ", questions=" + questions
                + "]";
    }
}