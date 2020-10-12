package com.diaprev.patient.controller;

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


import com.diaprev.patient.client.NoteClient;
import com.diaprev.patient.domain.dto.Note;

@Controller
public class NoteController {
	
	@Autowired
	private NoteClient noteClient;
	
	
	@RequestMapping("/note/list")
    public String homeNote(Model model)
    {
        model.addAttribute("notes", noteClient.getAllNotes());
        return "note/list";
    }
	
	   @RequestMapping("/note/patientList")
	    public String listPatientNote(@RequestParam int patientId, Model model)
	    {
	        model.addAttribute("notes", noteClient.getNotesByPatient(patientId));
	        model.addAttribute("patientId", patientId);
	        return "note/patientList";
	    }

	    @GetMapping("/note/add")
	    public String addNote(@RequestParam int patientId, Note note , Model model) {
	    	
	    	model.addAttribute("patientId", patientId);
	        return "note/add";
	    }

	    @PostMapping("/note/validate")
	    public String validate(@Valid Note note, BindingResult result, Model model) {
	        if (!result.hasErrors()) {
	        	noteClient.addNote(note);
	            model.addAttribute("notes", noteClient.getAllNotes());
	            return "redirect:/note/list";
	        }
	        return "note/add";
	    }

	    @GetMapping("/note/update/{id}")
	    public String showUpdateForm(@PathVariable("id") String id, Model model) {
	    	Note note = noteClient.getNote(id);
	        model.addAttribute("note", note);
	        return "note/update";
	    }

	    @PostMapping("/note/update/{id}")
	    public String updateNote(@PathVariable("id") String id, @Valid Note note,
	                             BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "note/update";
	        }
	        noteClient.updateNote(id,note);
	        model.addAttribute("notes", noteClient.getAllNotes());
	        return "redirect:/note/list";
	    }

	    @GetMapping("/note/delete/{id}")
	    public String deleteNote(@PathVariable("id") String id, Model model) {
	    	noteClient.deleteNote(id);
	        model.addAttribute("notes", noteClient.getAllNotes());
	        return "redirect:/note/list";
	    }
	    
	
	
	

}
