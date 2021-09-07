package com.olive.olive.dbservice.impl;

import com.olive.olive.dbservice.AddressDbService;
import com.olive.olive.dbservice.DoctorDetailsDbService;
import com.olive.olive.dbservice.HospitalDetailsDbService;
import com.olive.olive.dbservice.entity.HospitalDetailsEntity;
import com.olive.olive.dbservice.mapper.HospitalDetailsEMM;
import com.olive.olive.dbservice.repository.HospitalDetailsRepository;
import com.olive.olive.models.Address;
import com.olive.olive.models.DoctorDetails;
import com.olive.olive.models.HospitalDetails;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalDetailsDbServiceImpl implements HospitalDetailsDbService {
  private final HospitalDetailsRepository hospitalDetailsRepository;
  private final AddressDbService addressDbService;
  private final DoctorDetailsDbService doctorDetailsDbService;

  public HospitalDetailsDbServiceImpl(
      HospitalDetailsRepository hospitalDetailsRepository,
      AddressDbService addressDbService,
      DoctorDetailsDbService doctorDetailsDbService) {
    this.hospitalDetailsRepository = hospitalDetailsRepository;
    this.addressDbService = addressDbService;
    this.doctorDetailsDbService = doctorDetailsDbService;
  }

  @Override
  public HospitalDetails getHospitalDetailsById(int hospitalId) {
    HospitalDetailsEntity hospitalDetailsEntity =
        hospitalDetailsRepository.findByHospitalId(hospitalId);
    HospitalDetails hospitalDetails = HospitalDetailsEMM.map(hospitalDetailsEntity);
    Address address = addressDbService.getAddressById(hospitalDetailsEntity.getAddressId());
    List<DoctorDetails> doctorDetailsList =
        doctorDetailsDbService.getDoctorsByHospitalId(hospitalId, address);
    hospitalDetails.setAddress(address);
    hospitalDetails.setDoctorDetails(doctorDetailsList);
    return hospitalDetails;
  }

  @Override
  public void saveHospitalDetails(HospitalDetails hospitalDetails) {
    int addressId = addressDbService.saveAddress(hospitalDetails.getAddress());
    HospitalDetailsEntity hospitalDetailsEntity = HospitalDetailsEMM.map(hospitalDetails);
    hospitalDetailsEntity.setAddressId(addressId);
    HospitalDetailsEntity hospitalDetailsEntity1 =
        hospitalDetailsRepository.save(hospitalDetailsEntity);
    int hospitalId = hospitalDetailsEntity1.getHospitalId();
    doctorDetailsDbService.saveHospitalDoctorDetails(
        hospitalDetails.getDoctorDetails(), hospitalId, addressId);
  }

  @Override
  public Map<Integer, HospitalDetails> getHospitalDetailsForIds(List<Integer> hospitalDetailsIds) {
    Map<Integer, HospitalDetails> hospitalIdIdToHospitalDetails = new HashMap<>();
    for (int hospitalId : hospitalDetailsIds) {
      HospitalDetailsEntity hospitalDetailsEntity =
          hospitalDetailsRepository.findByHospitalId(hospitalId);
      HospitalDetails hospitalDetails = HospitalDetailsEMM.map(hospitalDetailsEntity);
      Address address = addressDbService.getAddressById(hospitalDetailsEntity.getAddressId());
      List<DoctorDetails> doctorDetailsList =
          doctorDetailsDbService.getDoctorsByHospitalId(hospitalId, address);
      hospitalDetails.setAddress(address);
      hospitalDetails.setDoctorDetails(doctorDetailsList);
      hospitalIdIdToHospitalDetails.put(hospitalId, hospitalDetails);
    }
    return hospitalIdIdToHospitalDetails;
  }
}
