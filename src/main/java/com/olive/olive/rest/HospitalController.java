package com.olive.olive.rest;

import com.olive.olive.models.DoctorDetails;
import com.olive.olive.models.DoctorType;
import com.olive.olive.models.HospitalDetails;
import com.olive.olive.models.Slot;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
annotation is a meta data which adds extra functionality to whatever it has been applied on
 */
@RestController
/*
@restController enables the class to accept rest request from
any kind of front end like android app, website or postman
 */
/*
HospitalController is normal java class. When we annotate it with @RestController then it is enabled to accept rest
request from any kind of frontend like android app, website or postman
When we make a request from postman we have 2 coordinates to uniquely identify any request
1.method example get put post
2.path /hospital/register
whenever we write any api it should uniquely resolved to one method
@RequestBody--implies whatever has come in RequestBody that should be serialized to the class on which
@RequestBody has been annotated
@PathVariable implies variable part in the path. Let's suppose the path is /user/{userId} then userId
is the path variable.From postman we will be calling /user/1234 which implies 1234 is the userId. The variable
which is annotated with @PathVariable will get 1234 as value in this case.
@RequestParam: this looks like /user/1234?isGoodUser=true&authuser=1. @RequestParam adds extra information to the
api call but @RequestParam has no role to play in deciding the method on which the api call will land
@ResponseBody: implies whatever is the return/response from the method should go back to front end in response body
consumes = MediaType.APPLICATION_JSON_VALUE-- this implies request will be accepted by the method on which path has been
resolved only and only if sender has sent the request body in json format, other format can  be xml
also the frontend has to pass a header content-type application/json otherwise request will be rejected straight away
produces = MediaType.APPLICATION_JSON_VALUE--this implies that the outgoing response will be converted to json
and sent
@RequestMapping: is used to map a request between frontend and a single backend method
Controller's work is to do adan-pradan of model, it will itself not do any logical processing, it will pass
the received data/request to the service class.
service class will process the request and return the response to controller and controller will pass back the same response to frontend
ResponseEntity<Void>: ResponseEntity<any class> means whatever we want to return is wrapped around <>
 */
@RequestMapping(value = "hospital")
public class HospitalController {
  /*
  1. Create/register a hospital : it will use post method
  2. Add a doctor: it will use put method
  3. remove a doctor: it will use put method
  4.  update hospital detail : it will use put method
  5. get hospital detail : it will use get method
  6. can ask for doctor wise booking detail(for a specified date range)
  7. can ask for hospital booking detail
  */
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/register",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseEntity<Void> registerHospital(
      @RequestBody HospitalDetails hospitalDetails) {
    /* HospitalDetails hospitalDetails1 = new HospitalDetails();
    hospitalDetails1.setHospitalName("columbia asia");
    hospitalDetails1.setEmailId("ashishchanchalani@gmail.com");
    hospitalDetails1.setContactNumber("9532489511");
    Address address = new Address();
    address.setAddressLine1("mujaffarpur");
    address.setAddressLine2("ghatiya gaon");
    hospitalDetails1.setAddress(address);*/
    return null;
  }

  @RequestMapping(
      method = RequestMethod.PUT,
      value = "{/{hospitalId}/doctor",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseEntity<Void> addDoctorToHospital(
      @PathVariable("hospitalId") int hospitalId, @RequestBody DoctorDetails doctorDetails) {
    return null;
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "{hospitalId}/doctor/{doctorId}")
  public @ResponseBody ResponseEntity<Void> removeDoctorFromHospital(
      @PathVariable("hospitalId") int hospitalId, @PathVariable("doctorId") int doctorId) {
    return null;
  }

  @RequestMapping(method = RequestMethod.PUT)
  public @ResponseBody ResponseEntity<Void> updateHospitalDetails(
      @RequestBody HospitalDetails hospitalDetails) {
    return null;
  }

  @RequestMapping(
      method = RequestMethod.GET,
      value = "/fetchHospital/{hospitalId}/{name}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseEntity<HospitalDetails> getHospitalDetails(
      @PathVariable("hospitalId") Integer id, @PathVariable("name") String aspatalKaNaam) {
    return null;
    // doctorvinci.com/hospital/fetchHospital/12445/cityhospital
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{hospitalId}")
  public @ResponseBody ResponseEntity<Void> removeHospital(
      @PathVariable("hospitalId") int hospitalId) {
    return null;
  }

  @RequestMapping(
      method = RequestMethod.GET,
      value = "/nearbyhospital/{name}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseEntity<List<HospitalDetails>> getNearbyHospitals(
      @PathVariable("name") String cityName,
      @RequestParam(value = "longitude", required = false) double longitude,
      @RequestParam(value = "latitude", required = false) double latitude,
      @RequestParam(value = "pageSize", required = false) double pageSize,
      @RequestParam(value = "offset", required = false) double offset,
      @RequestParam(value = "speciality", required = false) DoctorType doctorType) {
    return null;
  }

  @GetMapping(value = "/hospital/{hospitalId}/doctor/{doctorId}/slot")
  public ResponseEntity<List<Slot>> availableSlotsByDoctorIdAndDate(
      @PathVariable("doctorId") int doctorId,
      @PathVariable("hospitalId") int hospitalId,
      @RequestParam(value = "date", required = false) String date) {
    return null;
  }
}
