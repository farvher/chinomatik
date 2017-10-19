package com.chinomatik.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Record {
	
	@Id
	private int id;
	
	private LocalDateTime recordStart;
	
	private LocalDateTime recordEnd;
	
	private List<Event> events;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getRecordStart() {
		return recordStart;
	}

	public void setRecordStart(LocalDateTime recordStart) {
		this.recordStart = recordStart;
	}

	public LocalDateTime getRecordEnd() {
		return recordEnd;
	}

	public void setRecordEnd(LocalDateTime recordEnd) {
		this.recordEnd = recordEnd;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
	

}
