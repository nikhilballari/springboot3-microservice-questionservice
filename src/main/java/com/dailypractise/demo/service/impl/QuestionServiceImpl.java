package com.dailypractise.demo.service.impl;

import com.dailypractise.demo.entity.Question;
import com.dailypractise.demo.repository.QuestionRepository;
import com.dailypractise.demo.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question createQuestion(Question question) {
        log.info("Inside the method call - createQuestion()");
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        log.info("Inside the method call - getAllQuestions()");
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestion(Long questionId) {
        log.info("Inside the method call - getQuestion()");
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getQuestionsForQuizId(Long quizId) {
        log.info("Inside the method call - getQuestionsForQuizId()");
        return questionRepository.findQuestionsByQuizId(quizId);
    }

}
