package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.courses.Batch;
import com.exam.services.BatchService;

import lombok.Data;


@RestController
@RequestMapping("/batch")
@CrossOrigin("*")
public class BatchController {
	@Autowired
	private BatchService batchService;
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Batch createBatch(@RequestBody Batch batch) throws Exception {
			return batchService.createBatch(batch);
	}
	
	@PostMapping("/user-to-batch")
	@ResponseStatus(HttpStatus.OK)
	public Batch assignCourse(@RequestBody UserToBatchForm form) throws Exception {
			return batchService.addUserToBatch(form.getUsername(),form.getBatchname());
	}
	
	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public List<Batch> getBatches() {
			return batchService.getBatches();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Batch getBatch(@PathVariable Long id) {
			return batchService.getBatchById(id);
	}
	
	@PutMapping("/{Id}")
	@ResponseStatus(HttpStatus.OK)
	public Batch updateBatches(@RequestBody Batch batch, @PathVariable("Id") Long id) throws Exception {
		System.out.println(id);

		return batchService.updateBatch(batch, id);
	}
	
	@DeleteMapping("/{Id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCourses(@PathVariable("Id") Long id) throws Exception {
		System.out.println(id);
		batchService.deleteBatch(id);
	}
}

@Data
class UserToBatchForm {
	private String username;
	private String batchname;
}

