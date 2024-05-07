package com.dailypractise.demo.controller;

import com.dailypractise.demo.entity.Question;
import com.dailypractise.demo.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@Slf4j
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        log.info("Inside the method - createQuestion()");
        return questionService.createQuestion(question);
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        log.info("Inside the method - getAllQuestions()");
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable("id") Long questionId) {
        log.info("Inside the method - getQuestion()");
        return questionService.getQuestion(questionId);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsForQuizId(@PathVariable("quizId") Long quizId) {
        log.info("Inside the method - getQuestionsForQuizId()");
        return questionService.getQuestionsForQuizId(quizId);
    }
}
