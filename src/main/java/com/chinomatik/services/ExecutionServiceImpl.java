package com.chinomatik.services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.chinomatik.dto.ExecutionDto;
import com.chinomatik.model.CustomSequences;
import com.chinomatik.repository.ExecutionDAO;

@Service
public class ExecutionServiceImpl implements ExecutionService {

	@Autowired
	private ExecutionDAO executionDao;

	@Autowired
	private MongoOperations mongo;

	@Override
	public void save(ExecutionDto execution) {
		executionDao.save(ExecutionDto.dtoToEntity(execution));
	}

	@Override
	public List<ExecutionDto> findAll() {

		return executionDao.findAll().stream().map(i -> ExecutionDto.entityToDto(i)).collect(Collectors.toList());
	}

	@Override
	public ExecutionDto findById(Integer id) {
		return ExecutionDto.entityToDto(executionDao.findById(id).get());
	}

	@Override
	public void delete(Integer id) {
		executionDao.deleteById(id);
	}

	@Override
	public int getNextSequence(String seqName) {
		CustomSequences counter = mongo.findAndModify(query(where("_id").is(seqName)), new Update().inc("seq", 1),
				options().returnNew(true).upsert(true), CustomSequences.class);
		return counter.getSeq();
	}
}
