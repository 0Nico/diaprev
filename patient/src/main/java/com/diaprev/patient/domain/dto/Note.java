package com.diaprev.patient.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Note {

	private String id;
	
	@NotBlank(message = "A Note can't be blank")
	private String corps;
	
	@NotNull(message = "A note must be related with a patient")
	private int patientId;
	
}
