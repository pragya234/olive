package com.doctorvinci.doctorvinci.service;

import com.doctorvinci.doctorvinci.dbservice.DoctorDetailsDbService;
import com.doctorvinci.doctorvinci.exception.DoctorServiceRequestProcessingException;
import com.doctorvinci.doctorvinci.models.DoctorDetails;
import com.doctorvinci.doctorvinci.models.DoctorType;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
  private final DoctorDetailsDbService doctorDetailsDbService;
  private static final String DOCTOR_ALREADY_REGISTERED = "Doctor is already registered";
  private static final String DOCTOR_DNE = "Doctor does not exist";

  public DoctorService(DoctorDetailsDbService doctorDetailsDbService) {
    this.doctorDetailsDbService = doctorDetailsDbService;
  }

  public void registerADoctor(DoctorDetails doctorDetails)
      throws DoctorServiceRequestProcessingException {
    String phoneNumber = doctorDetails.getPhoneNumber();
    DoctorDetails existingDoctorDetails =
        doctorDetailsDbService.retrieveDoctorDetailsByPhoneNumber(phoneNumber);
    if (existingDoctorDetails == null) {
      doctorDetailsDbService.saveDoctorDetailInDb(doctorDetails);
    } else {
      throw new DoctorServiceRequestProcessingException(DOCTOR_ALREADY_REGISTERED);
    }
  }

  public void removeDoctor(int doctorId) throws DoctorServiceRequestProcessingException {
    DoctorDetails existingDoctorDetails =
        doctorDetailsDbService.retrieveDoctorDetailsFromDb(doctorId);
    if (existingDoctorDetails != null) {
      doctorDetailsDbService.deleteDoctorDetailInDb(doctorId);
    } else {
      throw new DoctorServiceRequestProcessingException(DOCTOR_DNE);
    }
  }

  public List<DoctorDetails> getNearByDoctors(
      String city,
      Double latitude,
      Double longitude,
      Integer pageSize,
      Double offset,
      DoctorType doctorType) {
    boolean searchByCity =
        (latitude == null && longitude == null && doctorType == null && city != null);
    boolean searchByCityAndDoctorType =
        (latitude == null && longitude == null && doctorType != null && city != null);
    boolean searchByLatLong =
        (latitude != null && longitude != null && doctorType == null && city == null);
    boolean searchByLatLongAndDoctorType =
        (latitude != null && longitude != null && doctorType != null && city == null);
    List<DoctorDetails> doctorDetailsList = null;
    if (searchByCity) {
      doctorDetailsList = doctorDetailsDbService.getDoctorsInCity(city);
    } else if (searchByCityAndDoctorType) {
      doctorDetailsList =
          doctorDetailsDbService.retrieveDoctorDetailsByDoctorTypeAndCity(doctorType, city);

    } else if (searchByLatLong) {
      doctorDetailsList =
          doctorDetailsDbService.getDoctorsInLatitudeAndLongitudeRange(
              latitude - 0.1, latitude + 0.1, longitude - 0.1, longitude + 0.1);
    } else if (searchByLatLongAndDoctorType) {
      doctorDetailsList =
          doctorDetailsDbService.getDoctorsInLatitudeAndLongitudeRangeByDoctorType(
              latitude - 0.1, latitude + 0.1, longitude - 0.1, longitude + 0.1, doctorType);
    }

    return doctorDetailsList;
  }

  public void updateDoctorDetails(DoctorDetails doctorDetails)
      throws DoctorServiceRequestProcessingException {
    int doctorId = doctorDetails.getDoctorId();
    DoctorDetails existingDoctorDetails =
        doctorDetailsDbService.retrieveDoctorDetailsFromDb(doctorId);
    if (existingDoctorDetails == null) {
      throw new DoctorServiceRequestProcessingException(DOCTOR_DNE);
    }
    // existingDoctorDetails.setDoctorFee();
  }
}
// -5 -4 -3 -2 -1 0 1 2 3 4 5
/*
String.valueOf(5);
here we have used value of function/method of string class, that means value of function/method is called
from our code
here we can see we have not created object of String class to call a method of String class
 */
/*
service class is the class that actually processes the request
all the logical processing happens in the service class
if something wrong happens while processing any request from controller then the method in which wrong has happened
will throw an exception
 */
