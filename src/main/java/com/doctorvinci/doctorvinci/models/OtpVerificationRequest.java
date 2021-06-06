package com.doctorvinci.doctorvinci.models;

import lombok.Data;

@Data
public class OtpVerificationRequest {
  private UserType userType;
  private String Otp;
}
