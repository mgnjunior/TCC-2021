package com.consultorio.management.Controller;

import com.consultorio.management.entity.dto.MedicRecordResponse;
import com.consultorio.management.entity.dto.MedicRequest;
import com.consultorio.management.entity.dto.MedicResponse;
import com.consultorio.management.entity.dto.MedicUpdateRequest;
import com.consultorio.management.entity.model.Medic;
import com.consultorio.management.exception.MedicNotFoundException;
import com.consultorio.management.repository.MedicRepository;
import com.consultorio.management.service.MedicService;
import com.consultorio.management.service.RecordServiceImplementation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/medics")
public class MedicController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MedicRepository medicRepository;

    @Autowired
    private MedicService medicService;

    @Autowired
    private RecordServiceImplementation recordServiceImplementation;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<List<MedicResponse>> getAllMedics() {
        List<Medic> medics = medicRepository.findAll();
        List<MedicResponse> responses = medics.stream().map(medic -> modelMapper.map(medic, MedicResponse.class)).collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAllMedicsByCrm/{id}")
    public ResponseEntity<List<MedicResponse>> getAllMedicsByCrm(@PathVariable("id")  Long id) {
        List<Medic> medics = medicRepository.findAll();
        List<MedicResponse> responses = medics.stream().map(medic -> modelMapper.map(medic, MedicResponse.class))
                .filter((MedicResponse medic) -> medic.getCrm() == id).collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    @PostMapping("/regMedics")
    public ResponseEntity<Medic> registerMedics(@RequestBody MedicRequest medicRequest) {
        Medic medic = modelMapper.map(medicRequest, Medic.class);
        medic = medicRepository.save(medic);
        return ResponseEntity.ok(medic);
    }

    @DeleteMapping("/deleteMedics/{id}")
    public ResponseEntity<Void> deleteMedics(@PathVariable String id) {
        Long medicsId = Long.parseLong(id);
        medicService.deleteById(medicsId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateMedics/{id}")
    public ResponseEntity<Void> updateMedic(@RequestBody MedicUpdateRequest medicUpdateRequest, @PathVariable("id") Long id) {
        medicService.updateMedic(medicUpdateRequest);
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findMedics/{id}")
    public ResponseEntity<MedicResponse> findMedicsById(@PathVariable("id") Long id) {
        var medic = medicRepository.findById(id).orElseThrow(() -> new MedicNotFoundException(id));
        MedicResponse medicResponse = modelMapper.map(medic, MedicResponse.class);
        return ResponseEntity.ok(medicResponse);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findMedicsRecord")
    public ResponseEntity<List<MedicRecordResponse>> findMedicsRecord() {
        List<MedicRecordResponse> medics = medicService.findMedicRecord();

        return ResponseEntity.ok(medics);
    }



}