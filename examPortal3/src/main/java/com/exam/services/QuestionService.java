package com.exam.services;

import java.util.Set;

import com.exam.model.exams.Question;
import com.exam.model.exams.Quiz;

public interface QuestionService {
    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(Long questionId);

    public Set<Question> getQuestionOfQuiz(Quiz quiz);

    public void deleteQuestion(Long qid);

}
