package com.exam.services;

import java.util.List;

import com.exam.model.courses.Course;

public interface CourseService {
	public Course addCourseToTrainer(String username,String courseName) throws Exception;

	public Course createCourse(Course course) throws Exception;

	public List<Course> getCourses();

	public Course getCourseById(Long cid) throws Exception;

	public void deleteCourse(Long cid);

	public Course updateCourse(Course course, Long cid) throws Exception;

	public Course removeCourseFromUser(String username, String coursename);

	
}
