package com.exam.services;

import java.util.List;

import com.exam.model.courses.Batch;

public interface BatchService {

	public Batch createBatch(Batch batch) throws Exception;

	public List<Batch> getBatches();

	public Batch addUserToBatch(String username, String batchname);

	public Batch getBatchById(Long id);

	public Batch updateBatch(Batch batch, Long id);

	public void deleteBatch(Long id);

}
