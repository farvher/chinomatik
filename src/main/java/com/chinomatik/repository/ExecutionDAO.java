package com.chinomatik.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chinomatik.model.Execution;

@Repository
public interface ExecutionDAO extends MongoRepository<Execution, Integer>{

}
