package com.doctorvinci.doctorvinci.dbservice;

import com.doctorvinci.doctorvinci.dbservice.entity.HospitalDetailsEntity;
import com.doctorvinci.doctorvinci.models.DoctorDetails;
import com.doctorvinci.doctorvinci.models.HospitalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface HospitalDetailsDbService {
HospitalDetails getHospitalDetailsById(int hospitalId);
void saveHospitalDetails(HospitalDetails hospitalDetails);
Map<Integer, HospitalDetails> getHospitalDetailsForIds(List<Integer> hospitalIds);


}
