package com.doctorvinci.doctorvinci.dbservice;

import com.doctorvinci.doctorvinci.models.Address;
import com.doctorvinci.doctorvinci.models.DoctorDetails;
import com.doctorvinci.doctorvinci.models.DoctorType;
import java.util.List;

public interface DoctorDetailsDbService {
  void saveDoctorDetailInDb(DoctorDetails doctorDetails);

  void saveHospitalDoctorDetails(
      DoctorDetails doctorDetails, int hospitalId, int hospitalAddressId);

  void saveHospitalDoctorDetails(
      List<DoctorDetails> doctorDetailsList, int hospitalId, int hospitalAddressId);

  void deleteDoctorDetailInDb(int doctorId);

  DoctorDetails retrieveDoctorDetailsFromDb(int doctorId);

  DoctorDetails retrieveDoctorDetailsByPhoneNumber(String phoneNumber);

  List<DoctorDetails> getDoctorsInCity(String city);

  List<DoctorDetails> retrieveDoctorDetailsByDoctorTypeAndCity(DoctorType doctorType, String city);

  List<DoctorDetails> getDoctorsInLatitudeAndLongitudeRange(
      double latitudeStart, double latitudeEnd, double longitudeStart, double longitudeEnd);

  List<DoctorDetails> getDoctorsInLatitudeAndLongitudeRangeByDoctorType(
      double latitudeStart,
      double latitudeEnd,
      double longitudeStart,
      double longitudeEnd,
      DoctorType doctorType);

  List<DoctorDetails> getDoctorsByHospitalId(int hospitalId, Address hospitalAddress);
}
/*address_table
address_id address_line1 address_line2 city pin_code statee
123         Aamghat          new colony ghazipur 233001 u.p
125        chaukaghat       kachiyawa   varanasi 221002  u.p
134        dadrighat                      ghazipur 233001  u.p
456                                      ghazipur
124                                      ghazipur
 */
// select * from address where city='ghazipur';String
// 123 134 456 124
/*
doctor_table
doctor_id  doctor_name  email_id  doctor_type address_id
234         Pragya Pandey pandeypragya026@gmail Cardiologist 123
568        Ashish Verma    ashiverma@gamail      jholachhap   456
721        Niharika Singh  niha@gmail       cardiologist    134
62387       Ritika           ritika@gmail.com cardiologist   125
587         Sudhanshu      sudhanshu@gmail      kidney       124
 */
// select * from doctor where address_id in( 123, 134, 456, 124) and doctor_type='cardiologist';
/*
234         Pragya Pandey pandeypragya026@gmail Cardiologist 123
721        Niharika Singh  niha@gmail       cardiologist    134
 */

/*
DoctorDetailsDbServiceForSqlServerDb implements DoctorDetailsDbService
DoctorDetailsDbServiceForMySqlDb implements DoctorDetailsDbService

DoctorDetailsDbService doctorDetailsDbService = new DoctorDetailsDbServiceForMySqlDb();
DoctorDetailsDbService doctorDetailsDbService = new DoctorDetailsDbServiceForSqlServerDb();

DoctorDetailsDbServiceForSqlServerDb doctorDetailsDbServiceForSqlServerDb = new DoctorDetailsDbServiceForSqlServerDb();
DoctorDetailsDbServiceForMySqlDb doctorDetailsDbServiceForMySqlDb = new DoctorDetailsDbServiceForMySqlDb();

 */
