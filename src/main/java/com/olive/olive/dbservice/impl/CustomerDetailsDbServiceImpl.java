package com.olive.olive.dbservice.impl;

import com.olive.olive.dbservice.CustomerDetailsDbService;
import com.olive.olive.models.CustomerDetails;
import java.util.List;
import java.util.Map;

public class CustomerDetailsDbServiceImpl implements CustomerDetailsDbService {
  @Override
  public CustomerDetails getCustomerDetailsById(int customerId) {
    return null;
  }

  @Override
  public void saveCustomerDetails(CustomerDetails customerDetails) {}

  @Override
  public Map<Integer, CustomerDetails> getCustomerDetailsForIds(List<Integer> addressIds) {
    return null;
  }
}
