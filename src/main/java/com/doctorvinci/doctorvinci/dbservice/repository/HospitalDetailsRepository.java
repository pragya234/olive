package com.doctorvinci.doctorvinci.dbservice.repository;

import com.doctorvinci.doctorvinci.dbservice.entity.DoctorDetailsEntity;
import com.doctorvinci.doctorvinci.dbservice.entity.HospitalDetailsEntity;
import com.doctorvinci.doctorvinci.models.DoctorDetails;
import com.doctorvinci.doctorvinci.models.HospitalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalDetailsRepository extends JpaRepository<HospitalDetailsEntity, Integer> {
        List<DoctorDetailsEntity> findDoctorsByHospitalId(int hospitalId);
        HospitalDetailsEntity findByHospitalId(int hospitalId);
        List<HospitalDetailsEntity> findHospitalDetailsByIdIn(List<Integer> hospitalIds);
        List<HospitalDetailsEntity> findHospitalDetailsByAddressIdIn(List<Integer> addressIds);
}
