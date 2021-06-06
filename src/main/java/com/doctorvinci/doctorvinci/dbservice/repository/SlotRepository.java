package com.doctorvinci.doctorvinci.dbservice.repository;

import com.doctorvinci.doctorvinci.dbservice.entity.SlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlotRepository extends JpaRepository<SlotEntity, Integer> {
    List<SlotEntity> findByDoctorId(Integer doctorID);
    List<SlotEntity> findByDoctorIdIn(List<Integer> doctorIDs);
}
