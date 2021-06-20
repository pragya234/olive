package com.doctorvinci.doctorvinci.dbservice.mapper;

import com.doctorvinci.doctorvinci.dbservice.entity.OrderEntity;
import com.doctorvinci.doctorvinci.models.Order;

import java.util.List;

public class OrderEMM {
  public static OrderEntity map(Order order) {
      OrderEntity orderEntity = new OrderEntity();
      orderEntity.setCustomerId(order.getCustomerId());
      orderEntity.setDoctorBookingCharges(order.getDoctorBookingCharges());
      orderEntity.setOrderStatus(order.getOrderStatus());
      orderEntity.setDoctorId(order.getDoctorId());
      orderEntity.setOrderingTime(order.getOrderingTime());
      orderEntity.setHospitalId(order.getHospitalId());
      orderEntity.setPrescriptionUrl(order.getPrescriptionUrl());
      orderEntity.setSlotId(order.getSlotId());
      orderEntity.setVisitDate(order.getVisitDate());
      return orderEntity;
  }

    public static Order map(OrderEntity orderEntity) {
        Order order = new Order();
        order.setCustomerId(orderEntity.getCustomerId());
        order.setDoctorBookingCharges(orderEntity.getDoctorBookingCharges());
        order.setOrderStatus(orderEntity.getOrderStatus());
        order.setDoctorId(orderEntity.getDoctorId());
        order.setOrderingTime(orderEntity.getOrderingTime());
        order.setHospitalId(orderEntity.getHospitalId());
        order.setPrescriptionUrl(orderEntity.getPrescriptionUrl());
        order.setSlotId(orderEntity.getSlotId());
        order.setVisitDate(orderEntity.getVisitDate());
        return order;
    }
}
