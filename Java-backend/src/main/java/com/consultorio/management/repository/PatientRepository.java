package com.consultorio.management.repository;

import com.consultorio.management.entity.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("patientRepository")
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByEmail(String email);

    List<Patient> findAll();

}
