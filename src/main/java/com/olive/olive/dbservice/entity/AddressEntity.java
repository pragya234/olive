package com.olive.olive.dbservice.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class AddressEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "address_id")
  private int addressId;

  @Column(name = "address_line1")
  private String addressLine1;

  @Column(name = "address_line2")
  private String addressLine2;

  private String landmark;

  @Column(name = "pin_code")
  private String pinCode;

  private String city;
  private String state;
  private double longitude;
  private double latitude;

  @Column(name = "google_map_url")
  private String googleMapUrl;
}
