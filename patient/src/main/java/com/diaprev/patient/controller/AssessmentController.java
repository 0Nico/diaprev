package com.diaprev.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.diaprev.patient.client.AssessmentClient;
import com.diaprev.patient.client.NoteClient;
import com.diaprev.patient.domain.Patient;
import com.diaprev.patient.domain.dto.Note;
import com.diaprev.patient.service.AssessmentService;
import com.diaprev.patient.service.PatientService;

@Controller
public class AssessmentController {

	@Autowired
	AssessmentService assessService;
	
	@Autowired
	NoteClient noteClient;
	
	@Autowired
	PatientService patientService;
	
	
	
	@GetMapping("/assessment")
    public String getAssessment(@RequestParam int patientId, Model model) {
    	
		List<Note> patientNotes = noteClient.getNotesByPatient(patientId);
		
		Patient patient = patientService.getPatient(patientId);
		String assessment = assessService.executeAssessment(patient, patientNotes);
		
		model.addAttribute("assessment", assessment);
		model.addAttribute("patientNotesNumber", patientNotes.stream().count());
    	model.addAttribute("patient", patient);
    	
        return "assessment/get";
    }
}
