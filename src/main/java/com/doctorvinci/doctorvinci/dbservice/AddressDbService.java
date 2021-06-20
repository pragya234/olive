package com.doctorvinci.doctorvinci.dbservice;

import com.doctorvinci.doctorvinci.models.Address;

import java.util.Map;
import java.util.Set;

public interface AddressDbService {
    Address getAddressById(int addressId);
    int saveAddress(Address address);
    void deleteAddress(int addressId);
    Map<Integer, Address> getAddressForIds(Set<Integer> addressIds);
    Map<Integer, Address> getByCity(String city);
    Map<Integer, Address> findAddressWithinLatitudeAndLongitudeRange(double latitudeStart, double latitudeEnd, double longitudeStart,
                                                                   double longitudeEnd);
}

/*
doctorService doctorDetailDbService se doctorDetails mangega, doctorDetailsDbService DoctorRepository se
doctorDestailsEntity mangega, jha use doctordetailsEntity me sirf adddressId milegi, to fir doctorDetailsDbService,
AddressDbService se Address mangega


 */