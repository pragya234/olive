package com.doctorvinci.doctorvinci.rest;

import com.doctorvinci.doctorvinci.models.DoctorDetails;
import com.doctorvinci.doctorvinci.models.DoctorType;
import com.doctorvinci.doctorvinci.models.Slot;
import com.doctorvinci.doctorvinci.service.DoctorService;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "doctor")
public class DoctorController {
  //private DoctorService doctorService = new DoctorService();

  /*
  1. register a doctor  : it will use post method
  3. remove a doctor: it will use delete method
  4. update doctor detail : it will use put method
  5. get doctor detail : it will use get method
  6. can ask for doctor wise booking detail(for a specified date range)
  */
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/register",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseEntity<Void> registerADoctor(
      @RequestBody DoctorDetails doctorDetails) {
    //doctorService.registerADoctor(doctorDetails);
    return  ResponseEntity.ok(null);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{doctorId}")
  public @ResponseBody ResponseEntity<Void> removeDoctor(
      @PathVariable(name = "doctorId") int doctorId) {
    return null;
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/{doctorId}")
  public @ResponseBody ResponseEntity<Void> updateDoctorDetails(
      @RequestBody DoctorDetails doctorDetails) {
    return null;
  }

  @RequestMapping(
      method = RequestMethod.GET,
      value = "/doctor/{name}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseEntity<List<DoctorDetails>> getDoctorDetails(
      @PathVariable("name") String drName) {
    return null;
  }

  @RequestMapping(
      method = RequestMethod.GET,
      value = "/nearByDoctors/{cityName}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseEntity<List<DoctorDetails>> getNearbyDoctors(
      @PathVariable("cityName") String cityName,
      @RequestParam(value = "longitude", required = false) double longitude,
      @RequestParam(value = "latitude", required = false) double latitude,
      @RequestParam(value = "pageSize", required = false) int pageSize,
      @RequestParam(value = "offset", required = false) double offset,
      @RequestParam(value = "speciality", required = false) DoctorType doctorType) {
    return null;
  }

  @GetMapping(value = "/doctor/{doctorId}/slot")
  public ResponseEntity<List<Slot>> availableSlotsByDoctorIdAndDate(
      @PathVariable("doctorId") int doctorId,
      @RequestParam(value = "date", required = false) String date) {
    return null;
  }
}

/*
two things with a method:
declaring a method
calling or using a method
*/
