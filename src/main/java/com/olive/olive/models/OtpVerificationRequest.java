package com.olive.olive.models;

import lombok.Data;

@Data
public class OtpVerificationRequest {
  private UserType userType;
  private String Otp;
}
