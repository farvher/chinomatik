package com.chinomatik.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.chinomatik.model.Execution;

public class ExecutionDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String executionName;

	private int id;

	private LocalDateTime scheduledStart;

	private List<Integer> recordsId;

	private int times;

	public String getExecutionName() {
		return executionName;
	}

	public void setExecutionName(String executionName) {
		this.executionName = executionName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getScheduledStart() {
		return scheduledStart;
	}

	public void setScheduledStart(LocalDateTime scheduledStart) {
		this.scheduledStart = scheduledStart;
	}

	public List<Integer> getRecordsId() {
		return recordsId;
	}

	public void setRecordsId(List<Integer> recordsId) {
		this.recordsId = recordsId;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static ExecutionDto entityToDto(Execution execution) {
		ExecutionDto executionDto = new ExecutionDto();

		executionDto.setId(execution.getId());
		executionDto.setExecutionName(execution.getExecutionName());
		executionDto.setScheduledStart(execution.getScheduledStart());
		executionDto.setTimes(execution.getTimes());
		executionDto.setRecordsId(execution.getRecordsId());

		return executionDto;

	}

	public static Execution dtoToEntity(ExecutionDto executionDto) {
		Execution execution = new Execution();

		execution.setId(executionDto.getId());
		execution.setExecutionName(executionDto.getExecutionName());
		execution.setScheduledStart(executionDto.getScheduledStart());
		execution.setTimes(executionDto.getTimes());
		execution.setRecordsId(executionDto.getRecordsId());

		return execution;
	}

}
