package com.exam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.exams.Category;
import com.exam.model.exams.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    public List<Quiz> findByCategory(Category cat);

    public List<Quiz> findByActive(Boolean b);

    public List<Quiz> findByCategoryAndActive(Category c, Boolean b);

}
