package com.restapi.project;

import com.restapi.project.surveyModel.Question;
import com.restapi.project.surveyModel.Survey;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigInteger;
import java.net.URI;
import java.security.SecureRandom;
import java.util.List;
import java.util.function.Predicate;

@AllArgsConstructor
@RestController
@RequestMapping("/surveys")
public class SurveyController {
    private SurveyService surveyService;

    @GetMapping("/allSurveys")
    public List<Survey> retriveAllSurveys() {
        return surveyService.retriveAllSurveys();
    }

    @GetMapping("/{surveyId}")
    public Survey retriveSurveyById(@PathVariable String surveyId) {
        Survey surveyById = surveyService.retriveSurveyById(surveyId);
        if (null == surveyById)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return surveyById;
    }

    @RequestMapping("/{surveyId}/questions")
    public List<Question> retrieveAllSurveyQuestions(@PathVariable String surveyId) {
        List<Question> questions = surveyService.retrieveAllSurveyQuestions(surveyId);

        if (questions == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return questions;
    }

    @RequestMapping("/{surveyId}/questions/{questionId}")
    public Question retrieveSpecificSurveyQuestion(@PathVariable String surveyId,
                                                   @PathVariable String questionId) {
        Question question = surveyService.retrieveSpecificSurveyQuestion
                (surveyId, questionId);

        if (question == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return question;
    }
}
