package com.chinomatik.services;

import java.util.List;

import com.chinomatik.dto.ExecutionDto;

public interface ExecutionService {

	void save(ExecutionDto execution);

	List<ExecutionDto> findAll();

	ExecutionDto findById(Integer id);

	void delete(Integer id);
	
	int getNextSequence(String seqName);
}
