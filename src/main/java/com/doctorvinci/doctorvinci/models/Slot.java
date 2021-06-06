package com.doctorvinci.doctorvinci.models;

import lombok.Data;

@Data
public class Slot {
  private int slotId;
  private String slotStartTime;
  private String slotEndTime;
  private int numberOfPatientPerSlot;
}
