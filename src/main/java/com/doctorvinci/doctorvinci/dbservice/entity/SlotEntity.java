package com.doctorvinci.doctorvinci.dbservice.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "slot")
public class SlotEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "slot_id")
  private int slotId;

  @Column(name = "slot_start_time")
  private String slotStartTime;

  @Column(name = "slot_end_time")
  private String slotEndTime;

  @Column(name = "number_of_patient_per_slot")
  private int numberOfPatientPerSlot;

  @Column(name = "doctor_id")
  private int doctorId;
}
/*
select * from slot where doctorId In(1, 2,3 )
 */
