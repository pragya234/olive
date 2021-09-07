package com.olive.olive.models;

public class LogInRequest {
  private String mobileNumber;
  private UserType userType;

  public void setUserType(UserType userType) {
    this.userType = userType;
  }

  public UserType getUserType() {
    return this.userType;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getMobileNumber() {
    return this.mobileNumber;
  }
}
