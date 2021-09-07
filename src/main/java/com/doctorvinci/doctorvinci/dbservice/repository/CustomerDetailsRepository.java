package com.doctorvinci.doctorvinci.dbservice.repository;

import com.doctorvinci.doctorvinci.dbservice.entity.CustomerDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetailsEntity, Integer> {
  CustomerDetailsEntity findByCustomerPhone(String customerPhone);

  CustomerDetailsEntity findByCustomerId(Integer customerId);
}
