package com.chinomatik.services;

import java.util.List;

import com.chinomatik.dto.EventDto;
import com.chinomatik.dto.RecordDto;
import com.chinomatik.model.Record;

public interface RecordService {


	void save(RecordDto record);

	RecordDto findRecord(Long recordId);
	
	List<RecordDto> findAll();

	void deleteAll();

	int getNextSequence(String seqName);

}
