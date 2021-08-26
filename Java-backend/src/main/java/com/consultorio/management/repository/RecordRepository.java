package com.consultorio.management.repository;

import com.consultorio.management.entity.model.Medic;
import com.consultorio.management.entity.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository("recordRepository")
public interface RecordRepository extends JpaRepository<Record, Long> {


}
