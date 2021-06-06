package com.doctorvinci.doctorvinci.models;

import java.util.List;
import lombok.Data;

@Data
public class HospitalDetails {

  private int hospitalId;
  private String hospitalName;
  private String emailId;
  private String contactNumber;
  private Address address;
  private String hospitalDescription;
  private String hospitalImageUrl;
  /*iska matlab ye hua jaise individual class hote hain jaise string hua ya address hua agar unka
  collection rakhna ho
  tab hum collection use karte hain, jaise list ya array, is case me hum list of DoctorRegistrationDetail kr rahe hain.
  jaise hospitalName ya emailId me hum single string rakhte hain*/
  private List<DoctorDetails> doctorDetails;
}
