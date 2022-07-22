package com.exam.services.implement;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.model.User;
import com.exam.model.courses.Batch;
import com.exam.repo.BatchRepository;
import com.exam.repo.userRepository;
import com.exam.services.BatchService;

@Service
@Transactional
public class BatchServiceImpl implements BatchService {
	
	@Autowired
	private BatchRepository batchRepository;
	@Autowired
	private userRepository userRepository;

	
	@Override
	public Batch createBatch(Batch batch) throws Exception {
		// TODO Auto-generated method stub
		Batch local = batchRepository.findByBatchname(batch.getBatchname());
		
		if (local != null) {
			System.out.println("batch already present");
//			throw new UserFoundException();
		} else {
			System.out.println(batch);
			local = batchRepository.save(batch);
//			if (roleRepository.findByroleName(ur.getRoleName()) == null)
//				roleRepository.save(ur);
		}
		return local;
	}

	@Override
	public List<Batch> getBatches() {
		// TODO Auto-generated method stub
		return batchRepository.findAll();
	}

	@Override
	public Batch addUserToBatch(String username, String batchname) {
		// TODO Auto-generated method stub
		System.out.println(batchname + " " + username);
		User user = userRepository.findByUsername(username);
		Batch batch = batchRepository.findByBatchname(batchname);
		if (user == null)
			throw new EntityNotFoundException("user not found");
		if (batch == null)
			throw new EntityNotFoundException("batch not found");
		batch.getUsers().add(user);
		return batchRepository.save(batch);
	}

	@Override
	public Batch getBatchById(Long id) {
		// TODO Auto-generated method stub
		return batchRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Batch Not Found"));
	}

	@Override
	public Batch updateBatch(Batch batch, Long id) {
		// TODO Auto-generated method stub
		if (batchRepository.findById(id).isEmpty()) {
			System.out.println("Batch not present");
			throw new EntityNotFoundException("Batch not present");
		}

		return batchRepository.save(batch);
	}

	@Override
	public void deleteBatch(Long id) {
		// TODO Auto-generated method stub
		if (batchRepository.findById(id).isEmpty()) {
			System.out.println("User not present");
			throw new EntityNotFoundException("Course not present");
		}

		batchRepository.deleteById(id);
	}

}
