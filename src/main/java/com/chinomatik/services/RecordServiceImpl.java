package com.chinomatik.services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.chinomatik.dto.RecordDto;
import com.chinomatik.model.CustomSequences;
import com.chinomatik.model.Record;
import com.chinomatik.repository.RecordDAO;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordDAO recordDao;

	@Autowired
	private MongoOperations mongo;

	@Override
	public int getNextSequence(String seqName) {
		CustomSequences counter = mongo.findAndModify(query(where("_id").is(seqName)), new Update().inc("seq", 1),
				options().returnNew(true).upsert(true), CustomSequences.class);
		return counter.getSeq();
	}

	@Override
	public void save(RecordDto record) {
		recordDao.save(RecordDto.dtoToEntity(record));
	}

	@Override
	public RecordDto findRecord(Long recordId) {
		if (recordDao.existsById(recordId)) {
			return RecordDto.entityToDto(recordDao.findById(recordId).get());
		}
		return null;
	}

	@Override
	public void deleteAll() {
		recordDao.deleteAll();
	}

	@Override
	public List<RecordDto> findAll() {
		return recordDao.findAll().stream().map(i-> RecordDto.entityToDto(i)).collect(Collectors.toList());
	}

	@Override
	public void deleteById(Long id) {
		recordDao.deleteById(id);
		
	}

	@Override
	public List<RecordDto> findByIdIn(List<Long> ids) {
		
		return recordDao.findByIdIn(ids).stream().map(i->RecordDto.entityToDto(i)).collect(Collectors.toList());
	}

}
