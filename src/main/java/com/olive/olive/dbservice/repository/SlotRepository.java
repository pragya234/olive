package com.olive.olive.dbservice.repository;

import com.olive.olive.dbservice.entity.SlotEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<SlotEntity, Integer> {
  List<SlotEntity> findByDoctorId(Integer doctorID);

  List<SlotEntity> findByDoctorIdIn(List<Integer> doctorIDs);
}
