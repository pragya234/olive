package com.doctorvinci.doctorvinci.models;

import lombok.Data;

@Data
public class CovidResource {
  private int hospitalId;
  private int oxygenCylinder;
  private int remdesivir;
  private int noOfPatient;
  private int totalBed;
  private Long lastUpdatedTime;
}
