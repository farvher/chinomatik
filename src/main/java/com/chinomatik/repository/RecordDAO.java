package com.chinomatik.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chinomatik.model.Record;

@Repository
public interface RecordDAO extends MongoRepository<Record, Long> {
	
	List<Record>  findByIdIn(Collection<Long> ids);

}
