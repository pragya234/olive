package com.doctorvinci.doctorvinci.dbservice.impl;

import com.doctorvinci.doctorvinci.dbservice.AddressDbService;
import com.doctorvinci.doctorvinci.dbservice.DoctorDetailsDbService;
import com.doctorvinci.doctorvinci.dbservice.HospitalDetailsDbService;
import com.doctorvinci.doctorvinci.dbservice.entity.HospitalDetailsEntity;
import com.doctorvinci.doctorvinci.dbservice.mapper.HospitalDetailsEMM;
import com.doctorvinci.doctorvinci.dbservice.repository.HospitalDetailsRepository;
import com.doctorvinci.doctorvinci.models.Address;
import com.doctorvinci.doctorvinci.models.DoctorDetails;
import com.doctorvinci.doctorvinci.models.HospitalDetails;
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
