package com.doctorvinci.doctorvinci.dbservice.mapper;

import com.doctorvinci.doctorvinci.dbservice.entity.CustomerDetailsEntity;
import com.doctorvinci.doctorvinci.models.CustomerDetails;

public class CustomerDetailsEMM {
  public static CustomerDetailsEntity map(CustomerDetails customerDetails) {
    CustomerDetailsEntity customerDetailsEntity = new CustomerDetailsEntity();
    customerDetailsEntity.setCustomerName(customerDetails.getCustomerName());
    customerDetailsEntity.setCustomerPhone(customerDetails.getCustomerPhone());
    customerDetailsEntity.setCustomerEmail(customerDetails.getCustomerEmail());
    customerDetailsEntity.setCustomerDob(customerDetails.getCustomerDob());
    return customerDetailsEntity;
  }

  public static CustomerDetails map(CustomerDetailsEntity customerDetailsEntity) {
    CustomerDetails customerDetails = new CustomerDetails();
    customerDetails.setCustomerName(customerDetailsEntity.getCustomerName());
    customerDetails.setCustomerPhone(customerDetailsEntity.getCustomerPhone());
    customerDetails.setCustomerEmail(customerDetailsEntity.getCustomerEmail());
    customerDetails.setCustomerDob(customerDetailsEntity.getCustomerDob());
    return customerDetails;
  }
}
