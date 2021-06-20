package com.doctorvinci.doctorvinci.dbservice.impl;

import com.doctorvinci.doctorvinci.dbservice.AddressDbService;
import com.doctorvinci.doctorvinci.dbservice.entity.AddressEntity;
import com.doctorvinci.doctorvinci.dbservice.mapper.AddressEMM;
import com.doctorvinci.doctorvinci.dbservice.repository.AddressRepository;
import com.doctorvinci.doctorvinci.models.Address;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class AddressDbServiceImpl implements AddressDbService {

   private final AddressRepository addressRepository;

    public AddressDbServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address getAddressById(int addressId) {
        AddressEntity addressEntity= addressRepository.findByAddressId(addressId);
       Address address=AddressEMM.map(addressEntity);
       return address;
    }

    @Override
    public int saveAddress(Address address) {
        AddressEntity addressEntity=AddressEMM.map(address);
        int addressId = addressRepository.save(addressEntity).getAddressId();
        return addressId;
    }

    @Override
    public void deleteAddress(int addressId) {
       addressRepository.deleteById(addressId);
    }

    @Override
    public Map<Integer, Address> getAddressForIds(Set<Integer> addressIds) {
        Map<Integer, Address> addressIdToAddress = new HashMap<>();
        List<AddressEntity> addressEntities= addressRepository.findByAddressIdIn(addressIds);
        for(AddressEntity addressEntity: addressEntities){
            Address address = AddressEMM.map(addressEntity);
           int addressId= addressEntity.getAddressId();
           addressIdToAddress.put(addressId, address);
        }
        return addressIdToAddress;
    }

    @Override
    public Map<Integer, Address> getByCity(String city) {
       Map<Integer, Address> addressIdToAddress = new HashMap<>();
       List<AddressEntity> addressEntities = addressRepository.findByCity(city);
        for(AddressEntity addressEntity: addressEntities){
            Address address = AddressEMM.map(addressEntity);
            int addressId= addressEntity.getAddressId();
            addressIdToAddress.put(addressId, address);
        }
        return addressIdToAddress;
    }

    @Override
    public Map<Integer, Address> findAddressWithinLatitudeAndLongitudeRange(double latitudeStart, double latitudeEnd, double longitudeStart, double longitudeEnd) {

        return null;
    }
}
/*
spring kya karta hai, jaha par bhi @Repository, @Service, @Controller, @Component annotated ho,
un classes k object banane ki koshish karta hai
kaise koshish karta hai?
vo defined constructor use karke banane ki koshish karta hai, jaise is case me line no.16 to line no.18
to is case me line no.16 vale constructor ko use karne k liye, spring will need object of implementation of
AddressRepository interface
ab question is who will provide the object of implementation of AddressRepository interface?
SpringDataJpa will provide that
how will SpringDataJpa will come to know that it has to create object of implementation of addressRepository?
whichsoever class extends JpaRepository, SpringDataJpa provides implementation class for that then create an object also.

 */