package com.exam.services;

import com.exam.model.schedule.Day;
import com.exam.model.schedule.Event;

public interface DayService {
	public Day addEvent(Day day,Event event) throws Exception;
	public Day createDay(Day day);
	public Day getDayByName(String dayName);
}
