package com.chinomatik.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.chinomatik.model.Event;
import com.chinomatik.model.Record;

public class RecordDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private LocalDateTime recordStart;

	private LocalDateTime recordEnd;

	private List<EventDto> events;

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

	public List<EventDto> getEvents() {
		return events;
	}

	public void setEvents(List<EventDto> events) {
		this.events = events;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static Record dtoToEntity(RecordDto recordDto) {
		Record record = new Record();

		record.setRecordEnd(recordDto.getRecordEnd());
		record.setRecordStart(recordDto.getRecordStart());
		record.setId(recordDto.getId());
		List<Event> events = new ArrayList<>();
		for (EventDto edto : recordDto.getEvents()) {
			events.add(EventDto.dtoToEntity(edto));
		}
		record.setEvents(events);

		return record;

	}

	public static RecordDto entityToDto(Record record) {

		RecordDto recordDto = new RecordDto();
		recordDto.setId(record.getId());
		recordDto.setRecordEnd(record.getRecordEnd());
		recordDto.setRecordStart(record.getRecordStart());
		List<EventDto> eventsDto = new ArrayList<>();
		for (Event e : record.getEvents()) {
			eventsDto.add(EventDto.entityToDto(e));

		}
		recordDto.setEvents(eventsDto);
		return recordDto;

	}

}
