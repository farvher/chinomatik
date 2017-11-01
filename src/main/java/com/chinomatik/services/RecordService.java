package com.chinomatik.services;

import java.util.List;

import com.chinomatik.dto.RecordDto;

public interface RecordService {


	void save(RecordDto record);
	
	void save();

	RecordDto findRecord(Long recordId);
	
	List<RecordDto> findAll();
	
	List<RecordDto> findByIdIn(List<Long> id);

	void deleteAll();
	
	void deleteById(Long id);

	int getNextSequence(String seqName);

}
