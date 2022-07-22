package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.schedule.Week;

public interface WeekRepository extends JpaRepository<Week, Long> {

}
