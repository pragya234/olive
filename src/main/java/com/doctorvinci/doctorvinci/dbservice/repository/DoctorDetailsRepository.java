package com.doctorvinci.doctorvinci.dbservice.repository;

import com.doctorvinci.doctorvinci.dbservice.entity.DoctorDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorDetailsRepository extends JpaRepository<DoctorDetailsEntity, Integer> {
    List<DoctorDetailsEntity> findByDoctorType(String doctorType);
    List<DoctorDetailsEntity> findByHospitalId(Integer hospitalId);
    DoctorDetailsEntity findByPhoneNumber(String phoneNumber);
    List<DoctorDetailsEntity> findByHospitalIdIn(List<Integer> hospitalIds);

}



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
