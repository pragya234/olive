package com.doctorvinci.doctorvinci.dbservice.mapper;

import com.doctorvinci.doctorvinci.dbservice.entity.HospitalDetailsEntity;
import com.doctorvinci.doctorvinci.models.HospitalDetails;

public class HospitalDetailsEMM {
  public static HospitalDetailsEntity map(HospitalDetails hospitalDetail) {
    HospitalDetailsEntity hospitalDetailsEntity = new HospitalDetailsEntity();
    hospitalDetailsEntity.setHospitalName(hospitalDetail.getHospitalName());
    hospitalDetailsEntity.setHospitalDescription(hospitalDetail.getHospitalDescription());
    hospitalDetailsEntity.setEmailId(hospitalDetail.getEmailId());
    hospitalDetailsEntity.setHospitalImageUrl(hospitalDetail.getHospitalImageUrl());
    hospitalDetailsEntity.setContactNumber(hospitalDetail.getContactNumber());
    hospitalDetailsEntity.setAddressId(hospitalDetail.getAddress().getAddressId());
    return hospitalDetailsEntity;
  }

  public static HospitalDetails map(HospitalDetailsEntity hospitalDetailsEntity) {

    HospitalDetails hospitalDetails = new HospitalDetails();
    hospitalDetails.setHospitalName(hospitalDetailsEntity.getHospitalName());
    hospitalDetails.setHospitalDescription(hospitalDetailsEntity.getHospitalDescription());
    hospitalDetails.setEmailId(hospitalDetailsEntity.getEmailId());
    hospitalDetails.setHospitalImageUrl(hospitalDetailsEntity.getHospitalImageUrl());
    hospitalDetails.setContactNumber(hospitalDetailsEntity.getContactNumber());
    return hospitalDetails;
  }
}
