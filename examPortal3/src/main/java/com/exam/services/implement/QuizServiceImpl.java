package com.exam.services.implement;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exams.Category;
import com.exam.model.exams.Quiz;
import com.exam.repo.QuizRepository;
import com.exam.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
	return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
	return quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
	return new LinkedHashSet<>(quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
	return quizRepository.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {
	quizRepository.deleteById(quizId);
    }

    @Override
    public java.util.List<Quiz> getQuizzesOfCategory(Category cat) {
	return quizRepository.findByCategory(cat);
    }

    @Override
    public List<Quiz> getActiveQuizzes() {
	return quizRepository.findByActive(true);
    }

    @Override
    public List<Quiz> getActiveQuizzesOfCategory(Category cat) {
	return quizRepository.findByCategoryAndActive(cat,true);
    }
    
    
    
    
}














