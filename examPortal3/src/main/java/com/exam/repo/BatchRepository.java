package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.courses.Batch;

public interface BatchRepository extends JpaRepository<Batch, Long> {

	Batch findByBatchname(String batchname);

}
