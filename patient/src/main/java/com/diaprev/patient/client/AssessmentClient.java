package com.diaprev.patient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.diaprev.patient.domain.dto.AssessmentDto;

@FeignClient(value = "assessment", url = "${CLIENT_ASSESSMENT_BASE_URL:http://localhost:8083/assessment}")
public interface AssessmentClient {
	
	@PostMapping
	public String executeAssessment(@RequestBody AssessmentDto assessmentDt);

}
