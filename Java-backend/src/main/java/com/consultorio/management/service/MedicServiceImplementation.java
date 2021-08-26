package com.consultorio.management.service;

import com.consultorio.management.entity.dto.MedicRecordResponse;
import com.consultorio.management.entity.dto.MedicRequest;
import com.consultorio.management.entity.dto.MedicUpdateRequest;
import com.consultorio.management.entity.model.Medic;
import com.consultorio.management.exception.MedicNotFoundException;
import com.consultorio.management.repository.MedicRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MedicServiceImplementation implements MedicService {

    @Autowired
    private ModelMapper modelMapper;

    private MedicRepository medicRepository;


    @Autowired
    public MedicServiceImplementation(MedicRepository obj) {
        medicRepository = obj;
    }

    @Override
    public List<Medic> findAll() {
        return medicRepository.findAll();
    }

    @Override
    public void save(Medic medic) {
        medicRepository.save(medic);
    }

    @Override
    public Medic findByEmail(String medic) {

        return medicRepository.findByEmail(medic);

    }

    @Override
    public void updateMedic(MedicUpdateRequest medicUpdateRequest) {
        Long id = medicUpdateRequest.getId();
        Medic medic = medicRepository.findById(medicUpdateRequest.getId()).orElseThrow(() -> new MedicNotFoundException(id));
        medic.refreshValues(medicUpdateRequest);
        medicRepository.saveAndFlush(medic);
    }

    @Override
    public List<Medic> findByCrm(String medic) {

        return medicRepository.findByCrm(medic);
    }

    public void deleteById(Long id) {
        medicRepository.deleteById(id);
    }

    @Override
    public List<MedicRecordResponse> findMedicRecord() {
        return findAll()
                .stream()
                .map(medic -> MedicRecordResponse.builder()
                        .label(medic.getFirstName())
                        .value(medic.getId()).build()).collect(Collectors.toList());
    }

    @Override
    public Medic findById(Long medicId) {
        return medicRepository.findById(medicId).orElseThrow(() -> new MedicNotFoundException(medicId));
    }


}
