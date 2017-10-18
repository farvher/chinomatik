package com.chinomatik.services;

import java.util.List;

import com.chinomatik.model.Event;

public interface EventService {

	void save(List<Event> event);

	void save(Event event);

	List<Event> findEvent(Long eventId);

	void deleteAll();

	int getNextSequence(String seqName);

}
