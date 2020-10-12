package com.diaprev.notes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diaprev.notes.dao.NoteRepository;
import com.diaprev.notes.domain.Note;


@Service
public class NoteService {

	@Autowired
	NoteRepository noteRepository;
	
	
	public Note getNote(String id) {
		
		return noteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Note Id:" + id));
	}
	
	
	public List<Note> getAllNotes() {
		
		return noteRepository.findAll();
	}
	
	public List<Note> getNotesByPatient(int id){
		return noteRepository.findByPatientId(id);
	}
	
	
	public void saveNote(Note note) {
		
		noteRepository.save(note);
	}
	
	public void deleteNote(String id) {
		
		Note note = noteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Note Id:" + id));
		noteRepository.delete(note);
	}
}
