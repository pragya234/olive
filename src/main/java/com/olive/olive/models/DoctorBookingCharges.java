package com.olive.olive.models;

import lombok.Data;

@Data
public class DoctorBookingCharges {
  private int doctorFee;
  private int tax;
  private int platformCharges;
  private int totalAmount;
}
