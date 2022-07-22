package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.courses.Course;
import com.exam.services.CourseService;

import lombok.Data;

@RestController
@RequestMapping("/course")
@CrossOrigin("*")
public class CourseController {
	@Autowired
	private CourseService courseService;

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Course createCourse(@RequestBody Course course) throws Exception {
		return courseService.createCourse(course);
	}

	@PostMapping("/course-to-user")
	@ResponseStatus(HttpStatus.OK)
	public Course assignCourse(@RequestBody CourseToTeacherForm form) throws Exception {
		return courseService.addCourseToTrainer(form.getUsername(), form.getCoursename());
	}
	
	@PostMapping("/remove-course-from-user")
	@ResponseStatus(HttpStatus.OK)
	public Course removeCourseFromUser(@RequestBody CourseToTeacherForm form) throws Exception {
		return courseService.removeCourseFromUser(form.getUsername(), form.getCoursename());
	}

	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public List<Course> getCourses() {
		System.out.println("getting courses");
		return courseService.getCourses();
	}

	@GetMapping("/{cid}")
	@ResponseStatus(HttpStatus.OK)
	public Course getCourse(@PathVariable Long cid) throws Exception {
		return courseService.getCourseById(cid);
	}

	@DeleteMapping("/{cId}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCourses(@PathVariable("cId") Long cid) throws Exception {
		System.out.println(cid);
		courseService.deleteCourse(cid);
	}

	@PutMapping("/{cId}")
	@ResponseStatus(HttpStatus.OK)
	public Course updateCourses(@RequestBody Course course, @PathVariable("cId") Long cid) throws Exception {
		System.out.println(cid);

		return courseService.updateCourse(course, cid);
	}

}

@Data
class CourseToTeacherForm {
	private String username;
	private String coursename;
}
