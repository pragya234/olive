package com.doctorvinci.doctorvinci.dbservice.entity;

import com.doctorvinci.doctorvinci.models.DoctorBookingCharges;
import com.doctorvinci.doctorvinci.models.OrderStatus;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order")
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "order_id")
  private int orderId;

  @Column(name = "slot_id")
  private int slotId;

  @Column(name = "customer_id")
  private int customerId;

  @Column(name = "doctor_id")
  private int doctorId;

  @Column(name = "hospital_id")
  private int hospitalId;

  @Column(name = "ordering_time")
  private long orderingTime;

  @Column(name = "visit_date")
  private String visitDate;

  @Column(name = "order_status")
  private OrderStatus orderStatus;

  @Column(name = "doctor_booking_charges")
  private DoctorBookingCharges doctorBookingCharges;

  @Column(name = "prescription_url")
  private String prescriptionUrl;
}
