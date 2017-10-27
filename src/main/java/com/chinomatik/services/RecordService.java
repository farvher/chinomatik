package com.chinomatik.services;

import java.util.Collection;
import java.util.List;

import com.chinomatik.dto.EventDto;
import com.chinomatik.dto.RecordDto;
import com.chinomatik.model.Record;

public interface RecordService {


	void save(RecordDto record);

	RecordDto findRecord(Long recordId);
	
	List<RecordDto> findAll();
	
	List<RecordDto> findByIdIn(Collection<Long> id);

	void deleteAll();
	
	void deleteById(Long id);

	int getNextSequence(String seqName);

}
