package com.doctorvinci.doctorvinci.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
  private int addressId;
  private String addressLine1;
  private String addressLine2;
  private String landmark;
  private String pinCode;
  private String city;
  private String state;
  private double longitude;
  private double latitude;
  private String googleMapUrl;
}
/*
models are used for adan pradan of data with the front end
fields of models are private that means we will need public getter and setter method for accessing those fields
there are diff diff ways for defining getter and setter method like in LogInRequest class we have
defined it manually
while in this class we have used @Getter and @Setter annotation on the class level to do the same
In place of using two annotations(@Getter  @Setter) we can also use @Data which inbuilt use @Getter @Setter
 */
