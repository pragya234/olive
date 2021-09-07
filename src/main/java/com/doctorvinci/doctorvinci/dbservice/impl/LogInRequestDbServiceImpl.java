package com.doctorvinci.doctorvinci.dbservice.impl;

import com.doctorvinci.doctorvinci.dbservice.LogInRequestDbService;
import com.doctorvinci.doctorvinci.dbservice.entity.LogInRequestEntity;
import com.doctorvinci.doctorvinci.dbservice.mapper.LogInRequestEMM;
import com.doctorvinci.doctorvinci.dbservice.repository.LogInRequestRepository;
import com.doctorvinci.doctorvinci.models.LogInRequest;
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
