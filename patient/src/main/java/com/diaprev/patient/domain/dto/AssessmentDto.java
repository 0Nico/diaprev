package com.diaprev.patient.domain.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssessmentDto {
	
	private Integer patientId;
	private Date birthDate;
	private List<String> notes;
	private String sex;
}
