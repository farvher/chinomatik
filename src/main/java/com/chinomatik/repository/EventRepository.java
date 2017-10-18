package com.chinomatik.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chinomatik.model.Event;
@Repository
public interface EventRepository extends MongoRepository<Event, Long>{

	List<Event> findByEventId(Long eventId);
	
}
