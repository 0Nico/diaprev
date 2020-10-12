package com.diaprev.patient.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diaprev.patient.client.AssessmentClient;
import com.diaprev.patient.domain.Patient;
import com.diaprev.patient.domain.dto.AssessmentDto;
import com.diaprev.patient.domain.dto.Note;

@Service
public class AssessmentService {

	
	@Autowired
	AssessmentClient assessmentClient;
	
	
	public String executeAssessment(Patient patient, List<Note> patientNotes) {
		AssessmentDto assmDto = new AssessmentDto();
		assmDto.setBirthDate(patient.getBirthDate());
		assmDto.setNotes(patientNotes.stream().map(note -> note.getCorps()).collect(Collectors.toList()));
		assmDto.setSex(patient.getSex());
		assmDto.setPatientId(patient.getId());
		
		return assessmentClient.executeAssessment(assmDto);
	}


}
