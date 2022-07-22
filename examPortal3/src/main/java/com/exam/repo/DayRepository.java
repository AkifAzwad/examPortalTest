package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.schedule.Day;

public interface DayRepository extends JpaRepository<Day, Long> {

	Day findByName(String dayName);

}
