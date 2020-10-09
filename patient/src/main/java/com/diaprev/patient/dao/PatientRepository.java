package com.diaprev.patient.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diaprev.patient.domain.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
