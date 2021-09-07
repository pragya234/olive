package com.olive.olive.dbservice.impl;

import com.olive.olive.dbservice.LogInRequestDbService;
import com.olive.olive.dbservice.entity.LogInRequestEntity;
import com.olive.olive.dbservice.mapper.LogInRequestEMM;
import com.olive.olive.dbservice.repository.LogInRequestRepository;
import com.olive.olive.models.LogInRequest;
import org.springframework.stereotype.Repository;

@Repository
public class LogInRequestDbServiceImpl implements LogInRequestDbService {
  private final LogInRequestRepository logInRequestRepository;

  public LogInRequestDbServiceImpl(LogInRequestRepository logInRequestRepository) {
    this.logInRequestRepository = logInRequestRepository;
  }

  @Override
  public LogInRequest getLogInRequestByMobileNumber(String mobileNumber) {
    LogInRequestEntity logInRequestEntity = logInRequestRepository.findByMobileNumber(mobileNumber);
    LogInRequest logInRequest = LogInRequestEMM.map(logInRequestEntity);
    return logInRequest;
  }

  @Override
  public void saveLogInRequest(LogInRequest logInRequest) {
    LogInRequestEntity logInRequestEntity = LogInRequestEMM.map(logInRequest);
    logInRequestRepository.save(logInRequestEntity);
  }
}
