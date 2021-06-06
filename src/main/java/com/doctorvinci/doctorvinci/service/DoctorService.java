package com.doctorvinci.doctorvinci.service;

import com.doctorvinci.doctorvinci.dbservice.DoctorDetailsDbService;
import com.doctorvinci.doctorvinci.models.DoctorDetails;

public class DoctorService {
  private DoctorDetailsDbService doctorDetailsDbService;

  public DoctorService(DoctorDetailsDbService doctorDetailsDbService) {
    this.doctorDetailsDbService = doctorDetailsDbService;
  }

  public void registerADoctor(DoctorDetails doctorDetails) {
    String.valueOf(5);
    /*
    here we have used value of function/method of string class, that means value of function/method is called
    from our code
    here we can see we have not created object of String class to call a method of String class
     */
  }
}
/*
service class is the class that actually processes the request
all the logical processing happens in the service class
if something wrong happens while processing any request from controller then the method in which wrong has happened
will throw an exception
 */
