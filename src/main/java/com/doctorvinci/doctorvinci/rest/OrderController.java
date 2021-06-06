package com.doctorvinci.doctorvinci.rest;

import com.doctorvinci.doctorvinci.models.DoctorBookingResponse;
import com.doctorvinci.doctorvinci.models.Order;
import java.util.List;

import com.doctorvinci.doctorvinci.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "order")
public class OrderController {
  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping(value = "/hospital/{hospitalId}/doctor/{doctorId}/{slotId}")
  public ResponseEntity<DoctorBookingResponse> bookDoctorInHospital(
      @PathVariable(value = "hospitalId") int hospitalId,
      @PathVariable(value = "doctorId") int doctorId,
      @PathVariable(value = "slotId") int slotId,
      @RequestParam(value = "booking-date", required = true) String date) {
    DoctorBookingResponse doctorBookingResponse=orderService.bookDoctorInHospital(hospitalId, doctorId, slotId, date);
    return ResponseEntity.ok(doctorBookingResponse);
  }

  @PostMapping(value = "/doctor/{doctorId}/{slotId}")
  public ResponseEntity<DoctorBookingResponse> bookDoctor(
      @PathVariable(value = "doctorId") int doctorId,
      @PathVariable(value = "slotId") int slotId,
      @RequestParam(value = "booking-date", required = true) String date) {
    DoctorBookingResponse doctorBookingResponse=orderService.bookDoctor(doctorId,slotId,date);
    return null;
  }

  @GetMapping(value = "/doctor/{doctorId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Order>> getBookingByDoctorId(
      @PathVariable(value = "doctorId") int doctorId,
      @RequestParam(value = "start-date", required = true) String startDate,
      @RequestParam(value = "end-date", required = true) String endDate) {

    return null;
  }

  @GetMapping(
      value = "/hospital/{hospitalId}/doctor/{doctorId}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Order>> getBookingByDoctorIdAndHospitalId(
      @PathVariable(value = "doctorId") int doctorId,
      @PathVariable(value = "hospitalId") int hospitalId,
      @RequestParam(value = "start-date", required = true) String startDate,
      @RequestParam(value = "end-date", required = true) String endDate) {
    return null;
  }

  @GetMapping(value = "/hospital/{hospitalId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Order>> getBookingByHospitalId(
      @PathVariable(value = "hospitalId") int hospitalId,
      @RequestParam(value = "start-date", required = true) String startDate,
      @RequestParam(value = "end-date", required = true) String endDate) {
    return null;
  }

  @GetMapping(value = "/customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Order>> getBookingByCustomerId(
      @PathVariable(value = "customerId") int customerId,
      @RequestParam(value = "start-date", required = true) String startDate,
      @RequestParam(value = "end-date", required = true) String endDate) {
    return null;
  }
}
