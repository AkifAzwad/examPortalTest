package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.schedule.Event;
import com.exam.model.schedule.Week;
import com.exam.services.WeekService;

@RestController
@RequestMapping("/schedule")
@CrossOrigin("*")
public class ScheduleController {

	@Autowired
	private WeekService weekService;

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Week createWeek(@RequestBody Week week) {
		return weekService.createWeek();
	}

	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public List<Week> getWeeks() {
		return weekService.getWeeks();
	}

	@PostMapping("/{id}/{dayName}")
	@ResponseStatus(HttpStatus.CREATED)
	public Week addEventToDayOfWeek(@PathVariable("id") Long id, 
			@PathVariable("dayName") String dayName,
			@RequestBody Event event) throws Exception {
		System.out.println("Trying to add event");
		return weekService.addEventToDayOfWeek(id, dayName, event);
	}
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Week getWeek(@PathVariable Long id) {
		return weekService.getWeekById(id);
	}


}
