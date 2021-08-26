package com.consultorio.management.service;

import com.consultorio.management.entity.dto.MedicRecordResponse;
import com.consultorio.management.entity.dto.MedicRequest;
import com.consultorio.management.entity.dto.MedicUpdateRequest;
import com.consultorio.management.entity.model.Medic;

import java.util.List;

public interface MedicService {

    public void updateMedic (MedicUpdateRequest medic);

    public List<Medic> findByCrm(String medic);

    public Medic findByEmail(String medic);

    public List<Medic> findAll();

    public void save(Medic medic);

    void deleteById(Long medicsId);

    List<MedicRecordResponse> findMedicRecord();

    Medic findById(Long medicId);
}
