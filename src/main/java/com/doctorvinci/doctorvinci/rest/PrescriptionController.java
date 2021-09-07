package com.doctorvinci.doctorvinci.rest;

import com.doctorvinci.doctorvinci.models.Prescription;
import com.doctorvinci.doctorvinci.service.LogInService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "prescription")
public class PrescriptionController {
  LogInService logInService = new LogInService();
  LogInController logInController = new LogInController(logInService);

  @GetMapping(value = "/{bookingId}")
  public ResponseEntity<Prescription> getPrescription(
      @PathVariable(value = "bookingId") int bookingId) {

    return null;
  }
}
// private HomePageService homePageService=new HomePageService();
// private HomePageController homePageController=new HomePageController(homePageService);
