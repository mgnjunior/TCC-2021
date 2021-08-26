package com.consultorio.management.Controller;


import com.consultorio.management.entity.dto.*;
import com.consultorio.management.entity.model.Record;
import com.consultorio.management.exception.RecordNotFoundException;
import com.consultorio.management.repository.RecordRepository;
import com.consultorio.management.service.MedicService;
import com.consultorio.management.service.RecordServiceImplementation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
    @RequestMapping(path = "/records")
public class RecordController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MedicService medicService;

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private RecordServiceImplementation recordServiceImplementation;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<List<RecordResponse>> getAllRecords() {
        List<Record> records = recordRepository.findAll();
        List<RecordResponse> responses = records.stream().map(patient -> modelMapper.map(patient, RecordResponse.class)).collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findRecords/{id}")
    public ResponseEntity<RecordResponse> findRecordsById(@PathVariable("id") Long id) {
        var record = recordRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        RecordResponse recordResponse = modelMapper.map(record, RecordResponse.class);
        return ResponseEntity.ok(recordResponse);
    }

    @PutMapping("/updateRecords/{id}")
    public ResponseEntity<Void> updateRecords(@RequestBody RecordsUpdateRequest recordUpdateRequest) {
        recordServiceImplementation.save(recordUpdateRequest);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/regRecords")
    public ResponseEntity<Record> registerRecords(@RequestBody RecordsRequest recordRequest) {
        Record record = recordServiceImplementation.save(recordRequest);
        return ResponseEntity.ok(record);
    }

    @DeleteMapping("/deleteRecords/{id}")
    public ResponseEntity<Void> deleteRecords(@PathVariable String id) {
        Long recordsId = Long.parseLong(id);
        recordServiceImplementation.deleteRecords(recordsId);
        return ResponseEntity.ok().build();
    }



}
