package com.doctorvinci.doctorvinci.rest;
import com.doctorvinci.doctorvinci.models.OtpRequest;
import com.doctorvinci.doctorvinci.models.OtpResponse;
import com.doctorvinci.doctorvinci.models.OtpVerificationRequest;
import com.doctorvinci.doctorvinci.models.OtpVerificationResponse;
import com.doctorvinci.doctorvinci.service.LogInService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "login")
public class LogInController {
  private final LogInService logInService;

  public LogInController(LogInService logInService) {
    this.logInService = logInService;
  }

  @RequestMapping(
      method = RequestMethod.POST,
      value = "/sendOtp",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseEntity<OtpResponse> sendOtp(@RequestBody OtpRequest otpRequest) {
    OtpResponse otpResponse= logInService.sendOtp(otpRequest);//
    return ResponseEntity.ok(otpResponse);
  }
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/verifyOtp",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseEntity<OtpVerificationResponse> verifyOtp(
          @RequestBody OtpVerificationRequest otpVerificationRequest) {
    OtpVerificationResponse otpVerificationResponse= logInService.verifyOtp(otpVerificationRequest);
    return ResponseEntity.ok(otpVerificationResponse);
  }
}

// get otp function
// otp verification + user will select user type
// wrong otp/success+ return user id and user type(frontend will add into its storage)
// frontend will redirect to the home page based on the user type
//kisi object ko banate time spring us class k constructor ka use karte hue us object ko banata hai
//we cant use a object method without creating object of the class it belongs to
/*A class is composed of methods/function, fields/variables, and constructor
method/function->can belong to class or object. If they belong to class then they are shared among objects
we dont need to create a object to call or use them, we can use them by using class
* */