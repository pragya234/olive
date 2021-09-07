package com.olive.olive.models;

import java.util.List;
import lombok.Data;

@Data
public class HomePage {
  private List<HospitalDetails> hospitalDetails;
  private List<DoctorDetails> doctors;
  private List<DoctorType> specialities;
}
