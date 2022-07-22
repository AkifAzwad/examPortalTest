package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.courses.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
