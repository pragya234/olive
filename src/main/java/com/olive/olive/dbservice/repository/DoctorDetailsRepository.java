package com.olive.olive.dbservice.repository;

import com.olive.olive.dbservice.entity.DoctorDetailsEntity;
import com.olive.olive.models.DoctorType;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorDetailsRepository extends JpaRepository<DoctorDetailsEntity, Integer> {
  DoctorDetailsEntity findByDoctorId(Integer doctorId);

  List<DoctorDetailsEntity> findByDoctorType(DoctorType doctorType);

  List<DoctorDetailsEntity> findByHospitalId(Integer hospitalId);

  DoctorDetailsEntity findByPhoneNumber(String phoneNumber); // why

  List<DoctorDetailsEntity> findByCity(String city);

  List<DoctorDetailsEntity> findByAddressIdIn(Set<Integer> addressIds);

  List<DoctorDetailsEntity> findByDoctorTypeAndAddressIdIn(
      DoctorType doctorType, Set<Integer> addressIds);

  @Override
  void deleteById(Integer integer);
}

/*
select * from doctor_details where doctor_type = 'cardiologist' and address_id in(1,22,43,14,5)
 */

/*
work of @Entity is to tell which table that particular class belongs to and work of @Column helps in mapping of class variable
to column in the table
then
how will the insertion and fetch happen? who will help with that?
one way of doing it is jdbc, other way of doing it is using spring data jpa
here jpa stands for java persistence api
jpa provides JpaRepository is a generic interface, so we provide <T,V> value. we have to substitutes
T with the entity class on which planning to operate,  which in this case is DoctorDetailsEntity
we have to substitute V with dataType of variable that is mapped to primary key column in the table
v is primary key ka datatype
 when we start
 */
