package com.chinomatik.robot;

import java.time.LocalDateTime;

import com.chinomatik.dto.RecordDto;

public interface RobotService {
	
	void execute(RecordDto record);
	
	void execute(RecordDto record,int times);
	
	
}
