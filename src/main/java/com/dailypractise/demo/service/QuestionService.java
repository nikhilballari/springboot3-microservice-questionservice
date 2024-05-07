package com.dailypractise.demo.service;

import com.dailypractise.demo.entity.Question;

import java.util.List;

public interface QuestionService {

    Question createQuestion(Question question);

    List<Question> getAllQuestions();

    Question getQuestion(Long questionId);

    List<Question> getQuestionsForQuizId(Long quizId);
}
