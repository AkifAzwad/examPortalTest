package com.exam.services.implement;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.helper.CourseFoundException;
import com.exam.helper.CourseNotFoundException;
import com.exam.helper.UserNotFoundException;
import com.exam.model.User;
import com.exam.model.courses.Course;
import com.exam.repo.CourseRepository;
import com.exam.repo.userRepository;
import com.exam.services.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private userRepository userRepository;

	

	@Override
	public Course createCourse(Course course) throws Exception {
		System.out.println(course);
		Course local = courseRepository.findBycourseName(course.getCourseName());

		if (local != null) {
			System.out.println("Course already present");
			throw new CourseFoundException();
		} else {
			local = courseRepository.save(course);
		}
		return local;
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	@Override
	public Course getCourseById(Long cid) {
		// TODO Auto-generated method stub
		return courseRepository.findById(cid).orElseThrow(() -> new EntityNotFoundException("Course Not Found"));
	}

	@Override
	public void deleteCourse(Long cid) {
		if (courseRepository.findById(cid).isEmpty()) {
			System.out.println("User not present");
			throw new EntityNotFoundException("Course not present");
		}

		courseRepository.deleteById(cid);
		
	}

	@Override
	public Course updateCourse(Course course, Long cid) throws Exception {
		// TODO Auto-generated method stub
		if (courseRepository.findById(cid).isEmpty()) {
			System.out.println("Course not present");
			throw new EntityNotFoundException("Course not present");
		}

		return courseRepository.save(course);
	}
	
	@Override
	public Course addCourseToTrainer(String username, String courseName) throws Exception {
//		log.info("Adding role {} to user {}", courseName, username);
		System.out.println(courseName + " " + username);
		User user = userRepository.findByUsername(username);
		Course course = courseRepository.findBycourseName(courseName);
		if (user == null)
			throw new UserNotFoundException();
		if (course == null)
			throw new CourseNotFoundException();
		course.getUsers().add(user);
		return courseRepository.save(course);
	}
	
	@Override
	public Course removeCourseFromUser(String username, String courseName) {
		// TODO Auto-generated method stub
		System.out.println(courseName + " " + username);
		User user = userRepository.findByUsername(username);
		Course course = courseRepository.findBycourseName(courseName);
		if (user == null)
			throw new EntityNotFoundException("user not found");
		if (course == null)
			throw new EntityNotFoundException("course not found");
		course.getUsers().remove(user);
		return courseRepository.save(course);
	}
	
	

}
