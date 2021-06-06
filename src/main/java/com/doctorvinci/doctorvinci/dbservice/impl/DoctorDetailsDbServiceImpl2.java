package com.doctorvinci.doctorvinci.dbservice.impl;

import com.doctorvinci.doctorvinci.dbservice.DoctorDetailsDbService;
import com.doctorvinci.doctorvinci.models.Address;
import com.doctorvinci.doctorvinci.models.DoctorDetails;
import com.doctorvinci.doctorvinci.models.DoctorType;
import java.util.List;

public class DoctorDetailsDbServiceImpl2 implements DoctorDetailsDbService {

  @Override
  public void saveDoctorDetailInDb(DoctorDetails doctorDetails) {
    // I am going to save doctor details in amazon nosql dynamo db
  }

  @Override
  public void deleteDoctorDetailInDb(int doctorId) {}

  @Override
  public DoctorDetails retrieveDoctorDetailsFromDb(int doctorId) {
    return null;
  }

  @Override
  public List<DoctorDetails> retrieveDoctorDetailsByDoctorTypeAndAddress(
      DoctorType doctorType, List<Address> addresses) {
    return null;
  }
}
