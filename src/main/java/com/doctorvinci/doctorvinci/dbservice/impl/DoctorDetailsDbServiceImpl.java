package com.doctorvinci.doctorvinci.dbservice.impl;

import com.doctorvinci.doctorvinci.dbservice.DoctorDetailsDbService;
import com.doctorvinci.doctorvinci.dbservice.entity.DoctorDetailsEntity;
import com.doctorvinci.doctorvinci.dbservice.mapper.DoctorDetailsEMM;
import com.doctorvinci.doctorvinci.models.Address;
import com.doctorvinci.doctorvinci.models.DoctorDetails;
import com.doctorvinci.doctorvinci.models.DoctorType;
import java.util.List;

public class DoctorDetailsDbServiceImpl implements DoctorDetailsDbService {
  @Override
  public void saveDoctorDetailInDb(DoctorDetails doctorDetails) {
    // I am going to save doctor details in my sql db
    // I cannot directly save doctorDetails into doctor_details table
    // I have to convert DoctorDetails to DoctorDetailsEntity
    // neither do you save doctorDetails directly to db nor do you return doctorDetailEntity
    // directly

    DoctorDetailsEntity doctorDetailsEntity = DoctorDetailsEMM.map(doctorDetails);
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
