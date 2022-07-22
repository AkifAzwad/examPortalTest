package com.exam.services.implement;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exams.Question;
import com.exam.model.exams.Quiz;
import com.exam.repo.QuestionRepository;
import com.exam.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
	return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
	return questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
	return new LinkedHashSet<>(questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
	return questionRepository.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionOfQuiz(Quiz quiz) {
	return questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long qid) {
	questionRepository.deleteById(qid);
    }
}
