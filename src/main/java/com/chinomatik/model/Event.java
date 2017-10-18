package com.chinomatik.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Event {
	@Id
	@GeneratedValue
	private int id;

	private Long eventId;

	private int x;

	private int y;

	private int key;

	private int position;

	private LocalDateTime date;

	private boolean isMouseEvent;

	private boolean isKeyEvent;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public boolean isMouseEvent() {
		return isMouseEvent;
	}

	public void setMouseEvent(boolean isMouseEvent) {
		this.isMouseEvent = isMouseEvent;
	}

	public boolean isKeyEvent() {
		return isKeyEvent;
	}

	public void setKeyEvent(boolean isKeyEvent) {
		this.isKeyEvent = isKeyEvent;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
}
