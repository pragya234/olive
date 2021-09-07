package com.olive.olive.dbservice;

import com.olive.olive.models.CustomerDetails;
import java.util.List;
import java.util.Map;

public interface CustomerDetailsDbService {
  CustomerDetails getCustomerDetailsById(int customerId);

  void saveCustomerDetails(CustomerDetails customerDetails);

  Map<Integer, CustomerDetails> getCustomerDetailsForIds(List<Integer> addressIds);
}
