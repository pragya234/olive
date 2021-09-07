package com.olive.olive.dbservice.repository;

import com.olive.olive.dbservice.entity.LogInRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogInRequestRepository extends JpaRepository<LogInRequestEntity, String> {
  LogInRequestEntity findByMobileNumber(String mobileNumber);
}
