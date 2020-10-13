package com.diaprev.assessment.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.diaprev.assessment.dto.AssessmentDto;

@Service
public class AssessmentService {

	private int triggers ;
	
	private int age;
	
	private List<String> symptomsList =  new ArrayList<String>() {{
		add("Hémoglobine A1C");
		add("Microalbumine");
		add("Taille");
		add("Poids");
		add("Fumeur");
		add("Anormal");
		add("Cholestérol");
		add("Vertige");
		add("Rechute");
		add("Réaction");
		add("Anticorps");
		}};
		

	
		
	public String executeAssessment(AssessmentDto assessmentDto) {
		triggers = 0;
		
		age = Period.between(assessmentDto.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
		
		symptomsList.stream().forEach(symptom -> {
			if (assessmentDto.getNotes().stream().anyMatch(note -> note.contains(symptom))) {
				triggers = triggers +1;
			}
		});
		
		if (age >= 30) {
			if( triggers >= 2) {
				if(triggers >= 6) {
					if(triggers >= 8) {
						return "Early onset";
					}
					return "In Danger";
				}
				return "Borderline";
			}
			
		} else {
			if (assessmentDto.getSex().equals("M")) {
				if (triggers >= 3) {
					if (triggers >= 5) {
						return "Early onset";
					}
					return "In Danger";
				}
			} else {
				if (triggers >= 4) {
					if (triggers >= 7) {
						return "Early onset";
					}
					return "In Danger";
				}
			}
			
		}
		
		return "None";
	}

}
