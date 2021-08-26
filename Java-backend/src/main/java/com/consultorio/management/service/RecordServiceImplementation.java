package com.consultorio.management.service;

import com.consultorio.management.entity.dto.Records;
import com.consultorio.management.entity.dto.RecordsUpdateRequest;
import com.consultorio.management.entity.model.Medic;
import com.consultorio.management.entity.model.Patient;
import com.consultorio.management.entity.model.Record;
import com.consultorio.management.exception.MedicNotFoundException;
import com.consultorio.management.exception.PatientNotFoundException;
import com.consultorio.management.exception.RecordNotFoundException;
import com.consultorio.management.repository.MedicRepository;
import com.consultorio.management.repository.PatientRepository;
import com.consultorio.management.repository.RecordRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImplementation {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MedicRepository medicRepository;

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private PatientRepository patientRepository;


    public void save(Record record) {
        recordRepository.save(record);
    }

    public List<Record> findAll() {
        return recordRepository.findAll();

    }

    public void updateRecord(RecordsUpdateRequest recordUpdateRequest) {
        if (!recordRepository.existsById(recordUpdateRequest.getId())){
            throw new RecordNotFoundException(recordUpdateRequest.getId());
        }
        Record record = modelMapper.map(recordUpdateRequest, Record.class);
        recordRepository.save(record);

    }

    public void deleteRecords(Long id) {
        recordRepository.deleteById(id);

    }

    public Record save(Records recordRequest) {
        Medic medic = medicRepository.findById(recordRequest.getMedicId()).orElseThrow(() -> new MedicNotFoundException(recordRequest.getMedicId()));
        Patient patient = patientRepository.findById(recordRequest.getPatientId()).orElseThrow(() -> new PatientNotFoundException(recordRequest.getPatientId()));
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        Record record = modelMapper.map(recordRequest, Record.class);
        record.setPatient(patient);
        record.setMedic(medic);
        return recordRepository.save(record);
    }
}
