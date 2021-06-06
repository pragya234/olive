package com.doctorvinci.doctorvinci.dbservice.entity;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "customer_details")
public class CustomerDetailsEntity {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Column(name = "customer_id")
  private Integer customerId;

  @Column(name = "customer_name")
  private String customerName;

  @Column(name = "customer_phone")
  private String customerPhone;

  @Column(name = "customer_email")
  private String customerEmail;

  @Column(name = "customer_dob")
  private Date customerDob;
}
