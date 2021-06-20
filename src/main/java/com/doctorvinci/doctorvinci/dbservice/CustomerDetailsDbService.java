package com.doctorvinci.doctorvinci.dbservice;

import com.doctorvinci.doctorvinci.models.CustomerDetails;

import java.util.List;
import java.util.Map;

public interface CustomerDetailsDbService {
    CustomerDetails getCustomerDetailsById(int customerId);
    void saveCustomerDetails(CustomerDetails customerDetails);
    Map<Integer, CustomerDetails> getCustomerDetailsForIds(List<Integer> addressIds);
}
