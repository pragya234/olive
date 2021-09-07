package com.olive.olive.models;

import lombok.Data;

@Data
public class DoctorBookingResponse {
  private int bookingId;
  private String slotStartTime;
  private String slotEndTime;
  private String date;
  private String doctorName;
  private String helperName;
  private String helperPhoneNumber;
  private boolean isHospitalDoctor;
  private Address address;
  private int hospitalId;
  private int doctorId;
  private String message;
}
