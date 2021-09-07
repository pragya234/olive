package com.doctorvinci.doctorvinci.dbservice.impl;

import com.doctorvinci.doctorvinci.dbservice.AddressDbService;
import com.doctorvinci.doctorvinci.dbservice.DoctorDetailsDbService;
import com.doctorvinci.doctorvinci.dbservice.SlotDbService;
import com.doctorvinci.doctorvinci.dbservice.entity.DoctorDetailsEntity;
import com.doctorvinci.doctorvinci.dbservice.mapper.DoctorDetailsEMM;
import com.doctorvinci.doctorvinci.dbservice.repository.DoctorDetailsRepository;
import com.doctorvinci.doctorvinci.models.Address;
import com.doctorvinci.doctorvinci.models.DoctorDetails;
import com.doctorvinci.doctorvinci.models.DoctorType;
import com.doctorvinci.doctorvinci.models.Slot;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorDetailsDbServiceImpl implements DoctorDetailsDbService {
  private final DoctorDetailsRepository doctorDetailsRepository;
  private final AddressDbService addressDbService;
  private final SlotDbService slotDbService;

  public DoctorDetailsDbServiceImpl(
      DoctorDetailsRepository doctorDetailsRepository,
      AddressDbService addressDbService,
      SlotDbService slotDbService) {
    this.doctorDetailsRepository = doctorDetailsRepository;
    this.addressDbService = addressDbService;
    this.slotDbService = slotDbService;
  }

  @Override
  public void saveDoctorDetailInDb(DoctorDetails doctorDetails) {
    // I am going to save doctor details in my sql db
    // I cannot directly save doctorDetails into doctor_details table
    // I have to convert DoctorDetails to DoctorDetailsEntity
    // neither do you save doctorDetails directly to db nor do you return doctorDetailEntity
    // directly

    DoctorDetailsEntity doctorDetailsEntity = DoctorDetailsEMM.map(doctorDetails);
    int addressId = addressDbService.saveAddress(doctorDetails.getAddress()); // need explanation
    doctorDetailsEntity.setAddressId(addressId);
    doctorDetailsRepository.save(doctorDetailsEntity);
  }

  @Override
  public void saveHospitalDoctorDetails(
      DoctorDetails doctorDetails, int hospitalId, int hospitalAddressId) {
    DoctorDetailsEntity doctorDetailsEntity = DoctorDetailsEMM.map(doctorDetails);
    doctorDetailsEntity.setHospitalId(hospitalId);
    // doctorDetailsRepository.save(doctorDetailsEntity);
    /*
    agar hum aisa karte hain, to doctorDetailsEntity db me save ho jayega, aur uska address id nahi hoga,
    next line par jo address hum set kar rahe hain, vo bas doctorDetailEntity object me rahega
    doctorDetailEntity object ka data doctorDetail table me tabhi show karta hai jab hum use explicitly save karte hain
     */
    doctorDetailsEntity.setAddressId(hospitalAddressId);
    doctorDetailsRepository.save(doctorDetailsEntity);
  }

  @Override
  public void saveHospitalDoctorDetails(
      List<DoctorDetails> doctorDetailsList, int hospitalId, int hospitalAddressId) {

    List<DoctorDetailsEntity> doctorDetailsEntityList = new ArrayList<>();

    for (DoctorDetails doctorDetails : doctorDetailsList) {
      DoctorDetailsEntity doctorDetailsEntity = DoctorDetailsEMM.map(doctorDetails);
      doctorDetailsEntity.setHospitalId(hospitalId);
      doctorDetailsEntity.setAddressId(hospitalAddressId);
      doctorDetailsEntityList.add(doctorDetailsEntity);
    }
    doctorDetailsRepository.saveAll(doctorDetailsEntityList);
  }

  @Override
  public void deleteDoctorDetailInDb(int doctorId) {
    doctorDetailsRepository.deleteById(doctorId);
  }

  @Override
  public DoctorDetails retrieveDoctorDetailsFromDb(int doctorId) {
    DoctorDetailsEntity doctorDetailsEntity = doctorDetailsRepository.findByDoctorId(doctorId);
    if (doctorDetailsEntity == null) {
      return null;
    }
    DoctorDetails doctorDetails = DoctorDetailsEMM.map(doctorDetailsEntity);
    Address address = addressDbService.getAddressById(doctorDetailsEntity.getAddressId());
    doctorDetails.setAddress(address);
    return doctorDetails;
  }

  @Override
  public DoctorDetails retrieveDoctorDetailsByPhoneNumber(String phoneNumber) {
    DoctorDetailsEntity doctorDetailsEntity =
        doctorDetailsRepository.findByPhoneNumber(phoneNumber);
    if (doctorDetailsEntity == null) {
      return null;
    }
    DoctorDetails doctorDetails = DoctorDetailsEMM.map(doctorDetailsEntity);
    Address address = addressDbService.getAddressById(doctorDetailsEntity.getAddressId());
    doctorDetails.setAddress(address);
    return doctorDetails;
  }

  @Override
  public List<DoctorDetails> getDoctorsInCity(String city) {
    List<DoctorDetails> doctorDetailsList = new ArrayList<>();
    List<DoctorDetailsEntity> doctorDetailsEntities = doctorDetailsRepository.findByCity(city);
    for (DoctorDetailsEntity doctorDetailsEntity : doctorDetailsEntities) {
      DoctorDetails doctorDetails = DoctorDetailsEMM.map(doctorDetailsEntity);
      Address address = addressDbService.getAddressById(doctorDetailsEntity.getAddressId());
      List<Slot> slotList = slotDbService.getSlotByDoctorId(doctorDetails.getDoctorId());
      doctorDetails.setSlots(slotList);
      doctorDetails.setAddress(address);
      doctorDetailsList.add(doctorDetails);
    }
    return doctorDetailsList;
  }

  @Override
  public List<DoctorDetails> retrieveDoctorDetailsByDoctorTypeAndCity(
      DoctorType doctorType, String city) {
    // List initialization
    List<DoctorDetails> doctorDetailsList = new ArrayList<>();
    Map<Integer, Address> addressIdToAddress = addressDbService.getByCity(city);
    /*
    1-> address1 .... 1 belong to doctor who is not a cardiologist, kyunki address pe to humne getByCity kiya hai na
    2-> address2 ....2 belongs to doctor who is a cardiologist
    3-> address3 ....3 belongs to doctor who is a cardiologist
    4-> address4 ....4 belongs to hospital which has 2 cardiologist doctors
    5-> address5 ....5 belongs to hospital which has 1 cardiologist doctor
    6-> address6 ....6 belongs to hospital which has no cardiologist doctors
     */
    List<DoctorDetailsEntity> doctorDetailsEntities =
        doctorDetailsRepository.findByDoctorTypeAndAddressIdIn(
            doctorType, addressIdToAddress.keySet());
    /*
    doctorDetailsRepository.findByDoctorTypeAndAddressIdIn
            (DoctorType.Cardiologist, [1,2,3,4,5,6]);
    List<DoctorDetailsEntity> doctorDetailsEntities = {
            doctorDetailEntity1 having addressId 2
            doctorDetailEntity2 having addressId 3
            doctorDetailEntity3 having addressId 4
            doctorDetailEntity4 having addressId 4
            doctorDetailEntity5 having addressId 5

            }
     */
    for (DoctorDetailsEntity doctorDetailsEntity :
        doctorDetailsEntities) { // doctorDetailEntity1 having addressId 2
      DoctorDetails doctorDetails = DoctorDetailsEMM.map(doctorDetailsEntity); // doctorDetails1
      Address address = addressIdToAddress.get(doctorDetailsEntity.getAddressId());
      /*
      addressIdToAddress.get(doctorDetailsEntity.getAddressId()); -> addressIdToAddress.get(2);
          Address address = address2
       */
      doctorDetails.setAddress(address); // abhi doctorDetail1 me hum address2 set kar rahe hain
      List<Slot> slotList = slotDbService.getSlotByDoctorId(doctorDetails.getDoctorId());
      doctorDetails.setSlots(slotList);
      doctorDetailsList.add(
          doctorDetails); // doctorDetailsList me hum doctorDetail1 add kar rahe hain
    } // ab yahi cheez doctorDetailEntity2 k liye repeat hogi
    return doctorDetailsList;
  }

  @Override
  public List<DoctorDetails> getDoctorsInLatitudeAndLongitudeRange(
      double latitudeStart, double latitudeEnd, double longitudeStart, double longitudeEnd) {
    List<DoctorDetails> doctorDetailsList = new ArrayList();
    Map<Integer, Address> addressForLatitudeLongitudeRange =
        addressDbService.findAddressWithinLatitudeAndLongitudeRange(
            latitudeStart, latitudeEnd, longitudeStart, longitudeStart);
    List<DoctorDetailsEntity> doctorDetailsEntities =
        doctorDetailsRepository.findByAddressIdIn(addressForLatitudeLongitudeRange.keySet());
    for (DoctorDetailsEntity doctorDetailsEntity : doctorDetailsEntities) {
      DoctorDetails doctorDetails = DoctorDetailsEMM.map(doctorDetailsEntity);
      Address address = addressForLatitudeLongitudeRange.get(doctorDetailsEntity.getAddressId());
      List<Slot> slotList = slotDbService.getSlotByDoctorId(doctorDetails.getDoctorId());
      doctorDetails.setSlots(slotList);
      doctorDetailsList.add(doctorDetails);
      doctorDetails.setAddress(address);
    }
    return doctorDetailsList;
  }

  @Override
  public List<DoctorDetails> getDoctorsInLatitudeAndLongitudeRangeByDoctorType(
      double latitudeStart,
      double latitudeEnd,
      double longitudeStart,
      double longitudeEnd,
      DoctorType doctorType) {
    List<DoctorDetails> doctorDetailsList = new ArrayList();
    Map<Integer, Address> addressForLatitudeLongitudeRange =
        addressDbService.findAddressWithinLatitudeAndLongitudeRange(
            latitudeStart, latitudeEnd, longitudeStart, longitudeStart);
    List<DoctorDetailsEntity> doctorDetailsEntities =
        doctorDetailsRepository.findByDoctorTypeAndAddressIdIn(
            doctorType, addressForLatitudeLongitudeRange.keySet());
    for (DoctorDetailsEntity doctorDetailsEntity : doctorDetailsEntities) {
      DoctorDetails doctorDetails = DoctorDetailsEMM.map(doctorDetailsEntity);
      Address address = addressForLatitudeLongitudeRange.get(doctorDetailsEntity.getAddressId());
      List<Slot> slotList = slotDbService.getSlotByDoctorId(doctorDetails.getDoctorId());
      doctorDetails.setSlots(slotList);
      doctorDetailsList.add(doctorDetails);
      doctorDetails.setAddress(address);
    }
    return doctorDetailsList;
  }

  @Override
  public List<DoctorDetails> getDoctorsByHospitalId(int hospitalId, Address hospitalAddress) {
    List<DoctorDetails> doctorDetailsList = new ArrayList();
    List<DoctorDetailsEntity> doctorDetailsEntities =
        doctorDetailsRepository.findByHospitalId(hospitalId);
    for (DoctorDetailsEntity doctorDetailsEntity : doctorDetailsEntities) {
      DoctorDetails doctorDetails = DoctorDetailsEMM.map(doctorDetailsEntity);
      doctorDetailsList.add(doctorDetails);
      List<Slot> slotList = slotDbService.getSlotByDoctorId(doctorDetails.getDoctorId());
      doctorDetails.setSlots(slotList);
      doctorDetails.setAddress(hospitalAddress);
    }
    return doctorDetailsList;
  }
}
