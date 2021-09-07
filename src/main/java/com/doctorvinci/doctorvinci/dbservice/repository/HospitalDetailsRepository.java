package com.doctorvinci.doctorvinci.dbservice.repository;

import com.doctorvinci.doctorvinci.dbservice.entity.HospitalDetailsEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalDetailsRepository extends JpaRepository<HospitalDetailsEntity, Integer> {
  HospitalDetailsEntity findByHospitalId(int hospitalId);

  List<HospitalDetailsEntity> findHospitalDetailsByIdIn(List<Integer> hospitalIds);

  List<HospitalDetailsEntity> findHospitalDetailsByAddressIdIn(List<Integer> addressIds);
}
