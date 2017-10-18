package com.chinomatik.services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.chinomatik.model.CustomSequences;
import com.chinomatik.model.Event;
import com.chinomatik.repository.EventRepository;


@Service
public class EventServiceImpl implements EventService{

	@Autowired private MongoOperations mongo;
	
	@Autowired
	private EventRepository eventRepository;
	
	
	@Override
	public void save(List<Event> event) {
		eventRepository.saveAll(event);
	}

	@Override
	public List<Event> findEvent(Long eventId) {
		return eventRepository.findByEventId(eventId);
	}

	@Override
	public void deleteAll() {
		eventRepository.deleteAll();
	}

	@Override
	public void save(Event event) {
		try{
		eventRepository.save(event);
		}catch(Exception ex){
			System.out.print(ex.getMessage()); 
		}
	}
	
	
	@Override
    public int getNextSequence(String seqName)
    {
        CustomSequences counter = mongo.findAndModify(
            query(where("_id").is(seqName)),
            new Update().inc("seq",1),
            options().returnNew(true).upsert(true),
            CustomSequences.class);
        return counter.getSeq();
    }

}
