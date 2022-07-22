package com.exam.services.implement;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.model.schedule.Day;
import com.exam.model.schedule.Event;
import com.exam.model.schedule.Week;
import com.exam.repo.WeekRepository;
import com.exam.services.DayService;
import com.exam.services.WeekService;

@Service
@Transactional
public class WeekServiceImpl implements WeekService {

	@Autowired
	WeekRepository weekRepository;
	@Autowired
	DayService dayService;

	@Override
	public Week createWeek() {
		// TODO Auto-generated method stub
		Week week = new Week();
		weekRepository.save(week);
		week.setName("Week " + week.getId());
		String[] daysOfTheWeek = { "sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday" };
		for (String dayName : daysOfTheWeek) {
			Day day = new Day();
			day.setName(dayName);
			week.getDays().add(day);
		}
		return weekRepository.save(week);
	}

	@Override
	public List<Week> getWeeks() {
		// TODO Auto-generated method stub
		return weekRepository.findAll();
	}

	@Override
	public Week getWeekById(Long id) {
		// TODO Auto-generated method stub
		return weekRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Week Not Found"));
	}

	@Override
	public Week addEventToDayOfWeek(Long id, String dayName, Event newEvent) throws Exception {
		// TODO Auto-generated method stub

		Week local = weekRepository.getById(id);
		if (local == null) {
			throw new EntityNotFoundException("This week hasn't arrived yet");
		}
		var days = local.getDays();
		Day curDay = new Day();
		boolean dayFound = false;
		for (Day day : days) {
			if (day.getName().equals(dayName)) {
				curDay = day;
				dayFound = true;
			}
		}
		if (!dayFound) {
			throw new EntityNotFoundException("Invalid Day");
		}

		curDay = dayService.addEvent(curDay, newEvent);
		local.getDays().add(curDay);
		return weekRepository.save(local);

	}

	@Override
	public Day getDayOfWeek(Long id, String dayName) {
		// TODO Auto-generated method stub
		var local = weekRepository.getById(id);
		var days = local.getDays();
		var curDay = new Day();
		for (Day day : days) {
			if (day.getName().equals(dayName)) {
				curDay = day;
			}
		}
		return curDay;
	}

}
