
package com.consultorio.management.service;

import com.consultorio.management.entity.dto.MedicRecordResponse;
import com.consultorio.management.entity.dto.MedicUpdateRequest;
import com.consultorio.management.entity.dto.PatientRecordReponse;
import com.consultorio.management.entity.dto.PatientUpdateRequest;
import com.consultorio.management.entity.model.Medic;
import com.consultorio.management.entity.model.Patient;
import com.consultorio.management.exception.MedicNotFoundException;
import com.consultorio.management.exception.PatientNotFoundException;
import com.consultorio.management.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("userService")
public class PatientService {

    @Autowired
    private ModelMapper modelMapper;

    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;

    }

    public Patient findByEmail(String email) {
        return patientRepository.findByEmail(email);

    }

    
    public void savePatient(Patient patient) {
        patientRepository.save(patient);

    }

    public List<Patient> findAll() {
        return patientRepository.findAll();

    }

    public void updatePatient(PatientUpdateRequest patientUpdateRequest) {
        if (!patientRepository.existsById(patientUpdateRequest.getId())){
            throw new PatientNotFoundException(patientUpdateRequest.getId());
        }
        Patient patient = modelMapper.map(patientUpdateRequest, Patient.class);
        patientRepository.save(patient);

    }



    public void deletePatients(Long id) {
        patientRepository.deleteById(id);

    }


    public List<PatientRecordReponse> findPatientsRecord() {
        return findAll()
                .stream()
                .map(patient -> PatientRecordReponse.builder()
                        .label(patient.getFirstName())
                        .value(patient.getId()).build()).collect(Collectors.toList());
    }
}
