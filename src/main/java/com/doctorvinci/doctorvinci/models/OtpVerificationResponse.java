package com.doctorvinci.doctorvinci.models;

import lombok.Data;

@Data
public class OtpVerificationResponse {
  private Boolean isOtpCorrect;
  private UserType userType;
}
