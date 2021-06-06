package com.doctorvinci.doctorvinci.models;

import java.util.List;
import lombok.Data;

@Data
public class DoctorDetails {

  private int doctorId;
  private String doctorName;
  private String phoneNumber;
  private String emailId;
  private String helperContact;

  private boolean isHospitalDoctor;
  private String hospitalId;
  private int doctorFee;
  private String doctorDescription;
  private String doctorImageUrl;

  private boolean hasAllowedFreeRevisit;
  private int freeRevisitTillXDaysAfterOrder;
  private boolean hasAllowedFreeChat;
  private int freeChatTillXDaysAfterOrder;

  private Address address;
  private DoctorType doctorType;
  private List<Slot> slots;
}
