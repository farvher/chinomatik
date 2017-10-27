package com.chinomatik.robot;

import java.util.List;

import com.chinomatik.dto.RecordDto;

public interface RobotService {
	
	void execute(RecordDto record);
	
	void execute(RecordDto record,int times);

	void execute(List<RecordDto> records);
	
	void execute(List<RecordDto> records, int times);
	
	
}
