package com.olive.olive.models;

import lombok.Data;

@Data
public class Medicine {
  private String name;
  private int noOfDoses;
  private MedicineTiming medicineTiming;
}
