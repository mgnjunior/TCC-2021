package com.consultorio.management.repository;

import com.consultorio.management.entity.dto.MedicRecordResponse;
import com.consultorio.management.entity.model.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("medicRepository")
public interface MedicRepository extends JpaRepository<Medic, Long> {


    Medic findByEmail(String medic);

    List<Medic> findByCrm(String medic);


}
