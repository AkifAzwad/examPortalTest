package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.courses.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {  

	Course findBycourseName(String courseName);

}
