package com.chinomatik.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chinomatik.model.Record;

@Repository
public interface RecordDAO extends MongoRepository<Record, Long> {

}
