package com.diaprev.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diaprev.patient.dao.PatientRepository;
import com.diaprev.patient.domain.Patient;

@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	
	
	public Patient getPatient(Integer id) {
		
		return patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Patient Id:" + id));
	}
	
	
	public List<Patient> getAllPatients() {
		
		return patientRepository.findAll();
	}
	
	
	public void savePatient(Patient patient) {
		
		patientRepository.save(patient);
	}
	
	public void deletePatient(Integer id) {
		
		Patient patient = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Patient Id:" + id));
		patientRepository.delete(patient);
	}

}
