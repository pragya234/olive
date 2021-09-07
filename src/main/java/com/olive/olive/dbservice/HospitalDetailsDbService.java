package com.olive.olive.dbservice;

import com.olive.olive.models.HospitalDetails;
import java.util.List;
import java.util.Map;

public interface HospitalDetailsDbService {
  HospitalDetails getHospitalDetailsById(int hospitalId);

  void saveHospitalDetails(HospitalDetails hospitalDetails);

  Map<Integer, HospitalDetails> getHospitalDetailsForIds(List<Integer> hospitalIds);
}
