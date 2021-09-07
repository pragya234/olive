package com.doctorvinci.doctorvinci.rest;

import com.doctorvinci.doctorvinci.models.DoctorType;
import com.doctorvinci.doctorvinci.service.HelperService;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "helper")
public class HelperController {
  private final HelperService helperService;

  public HelperController(HelperService helperService) {
    this.helperService = helperService;
  }

  @RequestMapping(
      method = RequestMethod.GET,
      value = "/cities",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody List<String> listOfCity() {
    List<String> cities = helperService.listOfCity();
    return cities;
  }

  @RequestMapping(
      method = RequestMethod.GET,
      value = "/specialities",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody List<DoctorType> listOfSpeciality(
      @RequestParam(value = "city", required = false) String city) {
    List<DoctorType> specialities = helperService.listOfSpeciality(city); // why this step?
    return specialities;
  }
}
