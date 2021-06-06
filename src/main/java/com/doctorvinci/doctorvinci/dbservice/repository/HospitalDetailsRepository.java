package com.doctorvinci.doctorvinci.dbservice.repository;

import com.doctorvinci.doctorvinci.dbservice.entity.HospitalDetailsEntity;
import com.doctorvinci.doctorvinci.models.DoctorDetails;
import com.doctorvinci.doctorvinci.models.HospitalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalDetailsRepository extends JpaRepository<HospitalDetailsEntity, Integer> {
        List<DoctorDetails> getDoctorsByHospitalId(int hospitalId);
        HospitalDetails getHospitalDetails(int hospitalId);
        List<HospitalDetails> getHospitalDetailsByIdIn(List<Integer> hospitalIds);
        List<HospitalDetails> getHospitalDetailsByAddressIdIn(List<Integer> addressIds);
}
