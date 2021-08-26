package com.consultorio.management.Controller;

import com.consultorio.management.entity.dto.*;
import com.consultorio.management.entity.model.Medic;
import com.consultorio.management.entity.model.Patient;
import com.consultorio.management.exception.MedicNotFoundException;
import com.consultorio.management.exception.PatientNotFoundException;
import com.consultorio.management.repository.MedicRepository;
import com.consultorio.management.repository.PatientRepository;
import com.consultorio.management.service.MedicServiceImplementation;
import com.consultorio.management.service.PatientService;
import com.consultorio.management.service.RecordServiceImplementation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Autowired
    private RecordServiceImplementation recordServiceImplementation;

    //ok
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponse> responses = patients.stream().map(patient -> modelMapper.map(patient, PatientResponse.class)).collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    //ok
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAllPatientsByCpf/{id}")
    public ResponseEntity<List<PatientResponse>> getAllPatientsByCpf(@PathVariable("id") String id) {
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponse> responses = patients.stream().map(patient -> modelMapper.map(patient, PatientResponse.class)).collect(Collectors.toList());
        List<PatientResponse> retorno = responses.stream().filter((PatientResponse p) -> p.getCpf().equals(id)).collect(Collectors.toList());

        return ResponseEntity.ok(retorno);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findPatients/{id}")
    public ResponseEntity<PatientResponse> findPatientsById(@PathVariable("id") Long id) {
        var patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
        PatientResponse patientResponse = modelMapper.map(patient, PatientResponse.class);
        return ResponseEntity.ok(patientResponse);
    }

    @PutMapping("/updatePatients/{id}")
    public ResponseEntity<Void> updatePatient(@RequestBody PatientUpdateRequest patientUpdateRequest) {
        patientService.updatePatient(patientUpdateRequest);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/regPatients")
    public ResponseEntity<Patient> registerPatients(@RequestBody PatientRequest patientRequest) {
        Patient patient = modelMapper.map(patientRequest, Patient.class);
        patient = patientRepository.save(patient);
        return ResponseEntity.ok(patient);
    }

    @DeleteMapping("/deletePatients/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable String id) {
        Long patientsId = Long.parseLong(id);
        patientService.deletePatients(patientsId);
        return ResponseEntity.ok().build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findPatientsRecord")
    public ResponseEntity<List<PatientRecordReponse>> findPatientsRecord() {
        List<PatientRecordReponse> patients = patientService.findPatientsRecord();

        return ResponseEntity.ok(patients);
    }


}
