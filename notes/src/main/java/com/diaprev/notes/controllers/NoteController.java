package com.diaprev.notes.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.diaprev.notes.domain.Note;
import com.diaprev.notes.services.NoteService;

@RestController
@RequestMapping("/patHistory")
public class NoteController {
	
	@Autowired
	NoteService noteService;
	
	@GetMapping
	public Note getNote(@RequestParam String id) {
		return noteService.getNote(id);
	}
	
	@GetMapping("/patientList")
	public List<Note> getNotesByPatient(@RequestParam int patientId){
		return noteService.getNotesByPatient(patientId);
	}
	
	@GetMapping("/list")
	public List<Note> getAllNotes(){
		return noteService.getAllNotes();
	}
	
	@PostMapping("/add")
	public void addNote(@RequestBody @Valid Note note) {
		noteService.saveNote(note);
	}
	
	
	@PutMapping
	public void updateNote(@RequestParam String id, @RequestBody @Valid Note note) {
		note.setId(id);
		noteService.saveNote(note);
	}
	
	@DeleteMapping
	public void deleteNote(@RequestParam String id) {
		noteService.deleteNote(id);
	}
	
	
	

}
