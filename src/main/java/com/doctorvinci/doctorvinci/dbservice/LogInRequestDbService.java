package com.doctorvinci.doctorvinci.dbservice;

import com.doctorvinci.doctorvinci.models.LogInRequest;

public interface LogInRequestDbService {
  LogInRequest getLogInRequestByMobileNumber(String mobileNumber);

  void saveLogInRequest(LogInRequest logInRequest);
}
