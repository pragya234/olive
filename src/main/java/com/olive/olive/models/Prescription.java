package com.olive.olive.models;

import java.util.List;
import lombok.Data;

@Data
public class Prescription {
  private int bookingId;
  private List<Medicine> medicines;
}
