package com.olive.olive.dbservice;

import com.olive.olive.models.LogInRequest;

public interface LogInRequestDbService {
  LogInRequest getLogInRequestByMobileNumber(String mobileNumber);

  void saveLogInRequest(LogInRequest logInRequest);
}
