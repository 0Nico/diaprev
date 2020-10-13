package com.diaprev.notes.domain;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "note")
public class Note {
	
	@Id
	private String id;
	
	@NotBlank(message = "A Note can't be blank")
	private String corps;
	
	@NotNull(message = "A note must be related with a patient")
	private Integer patientId;

}
