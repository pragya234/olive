package com.doctorvinci.doctorvinci.models;

import java.util.Date;
import lombok.Data;

@Data
public class CustomerDetails {

  private String customerName;
  private String customerPhone;
  private String customerEmail;
  private Date customerDob;
}
