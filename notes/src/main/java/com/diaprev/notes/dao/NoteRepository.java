package com.diaprev.notes.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.diaprev.notes.domain.Note;

public interface NoteRepository extends MongoRepository<Note, String>{
	
	List<Note> findByPatientId(int id);

}
