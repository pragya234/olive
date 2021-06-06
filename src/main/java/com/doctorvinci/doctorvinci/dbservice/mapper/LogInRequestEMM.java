package com.doctorvinci.doctorvinci.dbservice.mapper;

import com.doctorvinci.doctorvinci.dbservice.entity.LogInRequestEntity;
import com.doctorvinci.doctorvinci.models.LogInRequest;

public class LogInRequestEMM {
  public static LogInRequestEntity map(LogInRequest logInRequest) {
    LogInRequestEntity logInRequestEntity = new LogInRequestEntity();
    logInRequestEntity.setMobileNumber(logInRequest.getMobileNumber());
    logInRequestEntity.setUserType(logInRequest.getUserType());
    return logInRequestEntity;
  }

  public static LogInRequest map(LogInRequestEntity logInRequestEntity) {
    LogInRequest logInRequest = new LogInRequest();
    logInRequest.setMobileNumber(logInRequestEntity.getMobileNumber());
    logInRequest.setUserType(logInRequestEntity.getUserType());
    return logInRequest;
  }
}
