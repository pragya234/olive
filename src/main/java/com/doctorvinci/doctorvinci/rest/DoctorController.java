package com.doctorvinci.doctorvinci.rest;

import com.doctorvinci.doctorvinci.exception.DoctorServiceRequestProcessingException;
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
  private final DoctorService doctorService;

  public DoctorController(DoctorService doctorService) {
    this.doctorService = doctorService;
  }
  // private DoctorService doctorService = new DoctorService();

  /*
  1. register a doctor  : it will use post method
  3. remove a doctor: it will use delete method
  4. update doctor detail : it will use put method
  5. get doctor detail : it will use get method
  6. can ask for doctor wise booking detail(for a specified date range)
  */
  @RequestMapping(
      method = RequestMethod.POST,
      value =
          "/register", // we have not done anything technically wrong, but this is not the best
                       // practice.
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseEntity registerADoctor(@RequestBody DoctorDetails doctorDetails)
      throws DoctorServiceRequestProcessingException {
    doctorService.registerADoctor(doctorDetails);
    return ResponseEntity.ok()
        .build(); // isme kuchh bhi nhi return hoga, bas http status return hoga, 200
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{doctorId}")
  public @ResponseBody ResponseEntity removeDoctor(@PathVariable(name = "doctorId") int doctorId)
      throws DoctorServiceRequestProcessingException {
    doctorService.removeDoctor(doctorId);
    return ResponseEntity.ok().build();
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/{doctorId}")
  public @ResponseBody ResponseEntity<Void> updateDoctorDetails(
      @RequestBody DoctorDetails doctorDetails) throws DoctorServiceRequestProcessingException {
    doctorService.updateDoctorDetails(doctorDetails);
    return ResponseEntity.ok().build();
  }

  @RequestMapping(
      method = RequestMethod.GET,
      value = "/nearByDoctors",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseEntity<List<DoctorDetails>> getNearbyDoctors(
      @RequestParam(value = "cityName", required = false) String cityName,
      @RequestParam(value = "longitude", required = false) Double longitude,
      @RequestParam(value = "latitude", required = false) Double latitude,
      @RequestParam(value = "pageSize", required = false) Integer pageSize,
      @RequestParam(value = "offset", required = false) Double offset,
      @RequestParam(value = "speciality", required = false) DoctorType doctorType) {
    List<DoctorDetails> doctorDetailsList =
        doctorService.getNearByDoctors(cityName, longitude, latitude, pageSize, offset, doctorType);
    return ResponseEntity.ok(doctorDetailsList);
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
