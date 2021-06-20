package com.doctorvinci.doctorvinci.dbservice.impl;

import com.doctorvinci.doctorvinci.dbservice.AddressDbService;
import com.doctorvinci.doctorvinci.dbservice.HospitalDetailsDbService;
import com.doctorvinci.doctorvinci.dbservice.entity.AddressEntity;
import com.doctorvinci.doctorvinci.dbservice.entity.HospitalDetailsEntity;
import com.doctorvinci.doctorvinci.dbservice.mapper.AddressEMM;
import com.doctorvinci.doctorvinci.dbservice.mapper.HospitalDetailsEMM;
import com.doctorvinci.doctorvinci.dbservice.repository.HospitalDetailsRepository;
import com.doctorvinci.doctorvinci.models.Address;
import com.doctorvinci.doctorvinci.models.HospitalDetails;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HospitalDetailsDbServiceImpl implements HospitalDetailsDbService {
    private final HospitalDetailsRepository hospitalDetailsRepository;
    private final AddressDbService addressDbService;
    public HospitalDetailsDbServiceImpl(HospitalDetailsRepository hospitalDetailsRepository, AddressDbService addressDbService) {
        this.hospitalDetailsRepository = hospitalDetailsRepository;
        this.addressDbService = addressDbService;
    }

    @Override
    public HospitalDetails getHospitalDetailsById(int hospitalId) {
       HospitalDetailsEntity hospitalDetailsEntity = hospitalDetailsRepository.findByHospitalId(hospitalId);
       HospitalDetails hospitalDetails = HospitalDetailsEMM.map(hospitalDetailsEntity);
        Address address= addressDbService.getAddressById(hospitalDetailsEntity.getAddressId());
        hospitalDetails.setAddress(address);
        return   hospitalDetails;
    }

    @Override
    public void saveHospitalDetails(HospitalDetails hospitalDetails) {
        HospitalDetailsEntity hospitalDetailsEntity = HospitalDetailsEMM.map(hospitalDetails);
        hospitalDetailsRepository.save(hospitalDetailsEntity);
    }

    @Override
    public Map<Integer, HospitalDetails> getHospitalDetailsForIds(List<Integer> hospitalDetailsIds) {
        Map<Integer, HospitalDetails> hospitalIdIdToHospitalDetails = new HashMap<>();
        List<HospitalDetailsEntity> hospitalDetailsEntities =
                hospitalDetailsRepository.findHospitalDetailsByIdIn(hospitalIds);
        for(AddressEntity addressEntity: addressEntities){
            Address address = AddressEMM.map(addressEntity);
            int addressId= addressEntity.getAddressId();
            addressIdToAddress.put(addressId, address);
        }
        return addressIdToAddress;

        return null;
    }
}
