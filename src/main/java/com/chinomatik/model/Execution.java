package com.chinomatik.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Id;

public class Execution {
	
	@Id
	private int id;
	
	private String executionName;
	
	private List<Long> recordsId;
	
	private LocalDateTime scheduledStart;
	
	private int times;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExecutionName() {
		return executionName;
	}

	public void setExecutionName(String executionName) {
		this.executionName = executionName;
	}

	
	public List<Long> getRecordsId() {
		return recordsId;
	}

	public void setRecordsId(List<Long> recordsId) {
		this.recordsId = recordsId;
	}

	public LocalDateTime getScheduledStart() {
		return scheduledStart;
	}

	public void setScheduledStart(LocalDateTime scheduledStart) {
		this.scheduledStart = scheduledStart;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}
	
	
	
	
	

}
