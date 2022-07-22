package com.exam.services;

import java.util.List;

import com.exam.model.schedule.Day;
import com.exam.model.schedule.Event;
import com.exam.model.schedule.Week;

public interface WeekService {
	public Week createWeek();

	public List<Week> getWeeks();

	public Week getWeekById(Long id);

	public Day getDayOfWeek(Long id, String dayName);

	public Week addEventToDayOfWeek(Long id, String dayName, Event event) throws Exception;
}
