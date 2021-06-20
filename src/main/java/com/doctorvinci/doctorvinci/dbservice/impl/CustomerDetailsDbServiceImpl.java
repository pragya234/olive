package com.doctorvinci.doctorvinci.dbservice.impl;

import com.doctorvinci.doctorvinci.dbservice.CustomerDetailsDbService;
import com.doctorvinci.doctorvinci.models.CustomerDetails;

import java.util.List;
import java.util.Map;

public class CustomerDetailsDbServiceImpl implements CustomerDetailsDbService {
    @Override
    public CustomerDetails getCustomerDetailsById(int customerId) {
        return null;
    }

    @Override
    public void saveCustomerDetails(CustomerDetails customerDetails) {

    }

    @Override
    public Map<Integer, CustomerDetails> getCustomerDetailsForIds(List<Integer> addressIds) {
        return null;
    }
}
