package com.doctorvinci.doctorvinci.models;

import lombok.Data;

@Data
public class Order {

  private int orderId;
  private int slotId;
  private int customerId;
  private int doctorId;
  private int hospitalId;
  private long orderingTime;
  private String visitDate;
  private OrderStatus orderStatus;
  private DoctorBookingCharges doctorBookingCharges;
  private String prescriptionUrl;
}
