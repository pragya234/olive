package com.olive.olive.service;

import com.olive.olive.models.DoctorBookingResponse;
import com.olive.olive.models.Order;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
  public DoctorBookingResponse bookDoctorInHospital(
      int hospitalId, int doctorId, int slotId, String date) {
    return null;
  }

  public DoctorBookingResponse bookDoctor(int doctorId, int slotId, String date) {
    return null;
  }

  public List<Order> getBookingByDoctorId(int doctorId, String startDate, String endDate) {
    return null;
  }

  public List<Order> getBookingByDoctorIdAndHospitalId(
      int doctorId, int hospitalId, String startDate, String endDate) {
    return null;
  }

  public List<Order> getBookingByHospitalId(int hospitalId, String startDate, String endDate) {
    return null;
  }

  public List<Order> getBookingByCustomerId(int customerId, String startDate, String endDate) {
    return null;
  }
}
