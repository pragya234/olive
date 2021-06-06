package com.doctorvinci.doctorvinci.dbservice.mapper;

import com.doctorvinci.doctorvinci.dbservice.entity.DoctorDetailsEntity;
import com.doctorvinci.doctorvinci.models.DoctorDetails;

public class DoctorDetailsEMM {
  /*
  DoctorDetailsEMM means DoctorDetailsEntityModelMapper
  */
  public static DoctorDetailsEntity map(DoctorDetails doctorDetails) {
    DoctorDetailsEntity doctorDetailsEntity = new DoctorDetailsEntity();
    doctorDetailsEntity.setDoctorId(doctorDetails.getDoctorId());
    doctorDetailsEntity.setDoctorFee(doctorDetails.getDoctorFee());
    doctorDetailsEntity.setDoctorDescription(doctorDetails.getDoctorDescription());
    doctorDetailsEntity.setDoctorImageUrl(doctorDetails.getDoctorImageUrl());
    doctorDetailsEntity.setEmailId(doctorDetails.getEmailId());
    doctorDetailsEntity.setName(doctorDetails.getDoctorName());
    doctorDetailsEntity.setPhoneNumber(doctorDetails.getPhoneNumber());
    doctorDetailsEntity.setFreeChatTillXDaysAfterOrder(
        doctorDetails.getFreeChatTillXDaysAfterOrder());
    doctorDetailsEntity.setFreeRevisitTillXDaysAfterOrder(
        doctorDetails.getFreeRevisitTillXDaysAfterOrder());
    doctorDetailsEntity.setHasAllowedFreeChat(doctorDetails.isHasAllowedFreeChat());
    doctorDetailsEntity.setHasAllowedFreeRevisit(doctorDetails.isHasAllowedFreeRevisit());
    doctorDetailsEntity.setHelperContact(doctorDetails.getHelperContact());
    doctorDetailsEntity.setDoctorType(doctorDetails.getDoctorType());
    return doctorDetailsEntity;
  }

  public static DoctorDetails map(DoctorDetailsEntity doctorDetailsEntity) {
    DoctorDetails doctorDetails = new DoctorDetails();
    doctorDetails.setDoctorId(doctorDetailsEntity.getDoctorId());
    doctorDetails.setDoctorFee(doctorDetailsEntity.getDoctorFee());
    doctorDetails.setDoctorDescription(doctorDetailsEntity.getDoctorDescription());
    doctorDetails.setDoctorImageUrl(doctorDetailsEntity.getDoctorImageUrl());
    doctorDetails.setEmailId(doctorDetailsEntity.getEmailId());
    doctorDetails.setDoctorName(doctorDetailsEntity.getName());
    doctorDetails.setPhoneNumber(doctorDetailsEntity.getPhoneNumber());
    doctorDetails.setFreeChatTillXDaysAfterOrder(
        doctorDetailsEntity.getFreeChatTillXDaysAfterOrder());
    doctorDetails.setFreeRevisitTillXDaysAfterOrder(
        doctorDetailsEntity.getFreeRevisitTillXDaysAfterOrder());
    doctorDetails.setHasAllowedFreeChat(doctorDetailsEntity.isHasAllowedFreeChat());
    doctorDetails.setHasAllowedFreeRevisit(doctorDetailsEntity.isHasAllowedFreeRevisit());
    doctorDetails.setHelperContact(doctorDetailsEntity.getHelperContact());
    doctorDetails.setDoctorType(doctorDetailsEntity.getDoctorType());
    return doctorDetails;
  }
}
