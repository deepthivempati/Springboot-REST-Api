package com.restapi.project;

import com.restapi.project.surveyModel.Question;
import com.restapi.project.surveyModel.Survey;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/{surveyId}/questions")
    public List<Question> retrieveAllSurveyQuestions(@PathVariable String surveyId) {
        List<Question> questions = surveyService.retrieveAllSurveyQuestions(surveyId);

        if (questions == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return questions;
    }

    @GetMapping("/{surveyId}/questions/{questionId}")
    public Question retrieveSpecificSurveyQuestion(@PathVariable String surveyId,
                                                   @PathVariable String questionId) {
        Question question = surveyService.retrieveSpecificSurveyQuestion
                (surveyId, questionId);

        if (question == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return question;
    }

    @PostMapping("/{surveyId}/questions")
    public List<Question> addNewSurveyQuestion(@PathVariable String surveyId, @RequestBody Question questions) {
        surveyService.addNewSurveyQuestion(surveyId, questions);
        List<Question> question = surveyService.retrieveAllSurveyQuestions(surveyId);
        if (question == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return question;
    }

    //create random id for new question and show 201(created) status
    @PostMapping("/{surveyId}/newQuestions")
    public ResponseEntity<Object> addNewSurveyRandomQuestionId(@PathVariable String surveyId, @RequestBody Question questions) {
        String questionId = surveyService.addNewSurveyRandomQuestionId(surveyId, questions);
        //UriComponentsBuilder with additional static factory methods to create links based on current HttpServletRequest
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/questionId}").buildAndExpand(questionId).toUri();
        // {/questionId} will be added to current path /surveys/{surveyId}/newQuestions
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{surveyId}/questions/{questionId}")
    public List<Question> deleteSpecificSurveyQuestion(@PathVariable String surveyId,
                                                               @PathVariable String questionId) {
        List<Question> question = surveyService.deleteSpecificSurveyQuestion
                (surveyId,questionId);
        if (question == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return question;
    }
}