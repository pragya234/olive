package com.doctorvinci.doctorvinci.dbservice.mapper;

import com.doctorvinci.doctorvinci.dbservice.entity.AddressEntity;
import com.doctorvinci.doctorvinci.models.Address;

public class AddressEMM {
  public static AddressEntity map(Address address) {
    AddressEntity addressEntity = new AddressEntity();
    addressEntity.setAddressLine1(address.getAddressLine1());
    addressEntity.setAddressLine2(address.getAddressLine2());
    addressEntity.setLandmark(address.getLandmark());
    addressEntity.setCity(address.getCity());
    addressEntity.setState(address.getState());
    addressEntity.setPinCode(address.getPinCode());
    addressEntity.setLongitude(address.getLongitude());
    addressEntity.setLatitude(address.getLatitude());
    addressEntity.setGoogleMapUrl(address.getGoogleMapUrl());
    return addressEntity;
  }

  public static Address map(AddressEntity addressEntity) {
    Address address = new Address();
    address.setAddressLine1(addressEntity.getAddressLine1());
    address.setAddressLine1(addressEntity.getAddressLine2());
    address.setLandmark(addressEntity.getLandmark());
    address.setCity(addressEntity.getCity());
    address.setState(addressEntity.getState());
    address.setPinCode(addressEntity.getPinCode());
    address.setLongitude(addressEntity.getLongitude());
    address.setLatitude(addressEntity.getLatitude());
    address.setGoogleMapUrl(addressEntity.getGoogleMapUrl());
    return address;
  }
}
