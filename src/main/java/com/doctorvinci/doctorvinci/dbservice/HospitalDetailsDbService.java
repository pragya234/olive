package com.doctorvinci.doctorvinci.dbservice;

import com.doctorvinci.doctorvinci.models.HospitalDetails;
import java.util.List;
import java.util.Map;

public interface HospitalDetailsDbService {
  HospitalDetails getHospitalDetailsById(int hospitalId);

  void saveHospitalDetails(HospitalDetails hospitalDetails);

  Map<Integer, HospitalDetails> getHospitalDetailsForIds(List<Integer> hospitalIds);
}
