package com.olive.olive.dbservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "hospital_details")
public class HospitalDetailsEntity {
  @Column(name = "hospital_id")
  private int hospitalId;

  @Column(name = "hospital_name")
  private String hospitalName;

  @Column(name = "email_id")
  private String emailId;

  @Column(name = "contact_number")
  private String contactNumber;

  @Column(name = "address_id")
  private int addressId;

  @Column(name = "hospital_description")
  private String hospitalDescription;

  @Column(name = "hospital_image_url")
  private String HospitalImageUrl;
}
