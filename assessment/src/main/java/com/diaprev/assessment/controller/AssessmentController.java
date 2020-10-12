package com.diaprev.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diaprev.assessment.dto.AssessmentDto;
import com.diaprev.assessment.service.AssessmentService;

@RestController
@RequestMapping("/assessment")
public class AssessmentController {

	@Autowired
	AssessmentService assessmentService;
	
	@PostMapping
	public String executeAssessment(@RequestBody AssessmentDto assessmentDto) {
		return assessmentService.executeAssessment(assessmentDto);
	}
}
