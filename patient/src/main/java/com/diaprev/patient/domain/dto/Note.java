package com.diaprev.patient.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Note {

	private String id;
	private String corps;
	private int patientId;
	
}
