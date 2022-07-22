package com.exam.services.implement;

import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.helper.InvalidEventException;
import com.exam.helper.WrongEndTimeException;
import com.exam.helper.WrongStartTimeException;
import com.exam.model.schedule.Day;
import com.exam.model.schedule.Event;
import com.exam.repo.DayRepository;
import com.exam.services.DayService;

@Service
@Transactional
public class DayServiceImpl implements DayService {

	@Autowired
	private DayRepository dayRepository;

	@Override
	public Day addEvent(Day day, Event newEvent) throws Exception {
		// TODO Auto-generated method stub
		if (newEvent.getStartTime() >= newEvent.getEndTime()) {
			System.out.println("time format wrong");
			throw new InvalidEventException();
		}
		
		Day local = dayRepository.findById(day.getId()).orElseThrow(() -> new EntityNotFoundException());

		Set<Event> events = local.getEvents();
		boolean startTimeConflict = false;
		boolean endTimeConflict = false;
		for (Event event : events) {
			if (newEvent.getStartTime() >= event.getStartTime() && newEvent.getStartTime() <= event.getEndTime()) {
				startTimeConflict = true;
			}
			if (newEvent.getEndTime() >= event.getStartTime() && newEvent.getEndTime() <= event.getEndTime()) {
				endTimeConflict = true;
			}
		}
		if (!startTimeConflict && !endTimeConflict) {
			events.add(newEvent);
			local.setEvents(events);
			local = dayRepository.save(local);
		} else {
			if (startTimeConflict) {
				throw new WrongStartTimeException();
			} else {
				throw new WrongEndTimeException();
			}
		}

		return local;
	}

	@Override
	public Day createDay(Day newDay) {
		// TODO Auto-generated method stub

		String[] check = { "sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday" };
		boolean valid = false;

		for (String day : check) {
			if (day == newDay.getName())
				valid = true;
		}

		if (valid) {
			return dayRepository.save(newDay);
		} else {
			System.out.println("Day not found");
			throw new EntityNotFoundException("Day not found");
		}

	}

	@Override
	public Day getDayByName(String dayName) {
		// TODO Auto-generated method stub
		Day local = dayRepository.findByName(dayName);
		if (local == null) {
			System.out.println("Day not found");
			throw new EntityNotFoundException("Day not found");
		}
		return local;
	}

}
