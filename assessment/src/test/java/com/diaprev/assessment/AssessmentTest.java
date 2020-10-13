package com.diaprev.assessment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.diaprev.assessment.dto.AssessmentDto;
import com.diaprev.assessment.service.AssessmentService;


@SpringBootTest
public class AssessmentTest {
	
	@Autowired
	AssessmentService assessmentService;

	
	
	@Test
	public void testExecuteAssessment() {
		
		AssessmentDto assessmentDto = new AssessmentDto();
		
		assessmentDto.setBirthDate(new Date(1532516399000L)); // One year baby
		assessmentDto.setSex("M");
		List<String> noteList = Arrays.asList("Ce patient va bien", "Ce patient a de la fièvre");
		assessmentDto.setNotes(noteList);
		
		String assessment = assessmentService.executeAssessment(assessmentDto);
		assertEquals(assessment, "None");
		
		
		
		assessmentDto.setBirthDate(new Date(157762800000L)); // 45 years old
		assessmentDto.setSex("M");
		noteList = Arrays.asList("Ce patient va bien", "Ce patient a de la fièvre", "Ce patient a trop de Cholestérol", "Ce patient a un Poids Anormal");
		assessmentDto.setNotes(noteList);
		
		assessment = assessmentService.executeAssessment(assessmentDto);
		assertEquals(assessment, "Borderline");
		
		
		
		
		
		assessmentDto.setBirthDate(new Date(788914800000L)); // 25 years old
		assessmentDto.setSex("F");
		noteList = Arrays.asList("Ce patient est Fumeur. Aie aie.", "Ce patient a de la fièvre", "Ce patient a trop de Cholestérol", "Ce patient a un Poids Anormal");
		assessmentDto.setNotes(noteList);
		
		assessment = assessmentService.executeAssessment(assessmentDto);
		assertEquals(assessment, "In Danger");
		
		
		
		
		
		
		assessmentDto.setBirthDate(new Date(788914800000L)); // 25 years old
		assessmentDto.setSex("M");
		noteList = Arrays.asList("Ce patient est Fumeur. Aie aie.", "Ce patient a de la fièvre", "Ce patient a trop de Cholestérol", "Ce patient a un Poids Anormal", "Les Anticorps de ce patient sont fragiles.");
		assessmentDto.setNotes(noteList);
		
		assessment = assessmentService.executeAssessment(assessmentDto);
		assertEquals(assessment, "Early onset");
		
	}
}


