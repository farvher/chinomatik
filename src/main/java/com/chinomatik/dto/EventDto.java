package com.chinomatik.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.chinomatik.model.Event;

public class EventDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer x;

	private Integer y;

	private Integer key;

	private LocalDateTime date;

	private Long position;

	private String event;

	public EventDto(Integer x, Integer y, Integer key, LocalDateTime date, Long position, String event) {
		super();
		this.x = x;
		this.y = y;
		this.key = key;
		this.date = date;
		this.position = position;
		this.event = event;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public static Event dtoToEntity(EventDto eventDto) {

		Event event1 = new Event();
		event1.setDate(eventDto.getDate());
		event1.setKey(eventDto.getKey());
		event1.setEvent(eventDto.getEvent());
		event1.setX(eventDto.getX());
		event1.setY(eventDto.getY());
		event1.setPosition(eventDto.getPosition());

		return event1;

	}

	public static EventDto entityToDto(Event event) {
		return new EventDto(event.getX(), event.getY(), event.getKey(), event.getDate(), event.getPosition(),
				event.getEvent());
	}

}
