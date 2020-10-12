package com.diaprev.patient.client;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.diaprev.patient.domain.dto.Note;


@FeignClient(value = "note", url = "${CLIENT_NOTE_BASE_URL:http://localhost:8082/patHistory}")
public interface NoteClient {

	@GetMapping
	public Note getNote(@RequestParam String id) ;
	
	@GetMapping("/list")
	public List<Note> getAllNotes();
	
	@GetMapping("/patientList")
	public List<Note> getNotesByPatient(@RequestParam int patientId);
	
	@PostMapping("/add")
	public void addNote(@RequestBody @Valid Note note);
	
	@DeleteMapping
	public void deleteNote(@RequestParam String id);
	
	@PutMapping
	public void updateNote(@RequestParam String id, @RequestBody @Valid Note note);
}
