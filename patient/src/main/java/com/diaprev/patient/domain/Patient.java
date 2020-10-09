package com.diaprev.patient.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "First Name is mandatory")
	private String firstName;
	
	@NotBlank(message = "Last Name is mandatory")
	private String lastName;
	
	@Past(message = "BirthDate is mandatory")
	private Date birthdate;
	
	@NotBlank(message = "adress is mandatory")
	private String adress;
	
	@NotBlank
	@Pattern(regexp="^(M|F)$", message = "Sex must bu M or F")
	private String sex;
	
	@NotBlank(message= "Patient must have a phone number")
	private String phone;
	
	private String family;

}
