package com.olive.olive.dbservice.impl;

import com.olive.olive.dbservice.OrderDbService;
import com.olive.olive.dbservice.entity.OrderEntity;
import com.olive.olive.dbservice.mapper.OrderEMM;
import com.olive.olive.dbservice.repository.OrderRepository;
import com.olive.olive.models.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderDbServiceImpl implements OrderDbService {
  private final OrderRepository orderRepository;

  public OrderDbServiceImpl(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public Order getOrderByOrderId(int orderId) {
    OrderEntity orderEntity = orderRepository.findOrderByOrderId(orderId);
    Order order = OrderEMM.map(orderEntity);
    return order;
  }

  @Override
  public List<Order> getOrderByCustomerId(int customerId) {
    List<OrderEntity> orderEntities = orderRepository.findByCustomerId(customerId);
    List<Order> orders = new ArrayList<>();
    // for every orderEntity in orderEntities
    for (OrderEntity orderEntity : orderEntities) {
      Order order = OrderEMM.map(orderEntity);
      orders.add(order);
    }
    return orders;
  }

  @Override
  public List<Order> getOrderByDoctorId(int doctorId) {
    List<OrderEntity> orderEntities = orderRepository.findByDoctorId(doctorId);
    List<Order> orders = new ArrayList<>();
    // for every orderEntity in orderEntities
    for (OrderEntity orderEntity : orderEntities) {
      Order order = OrderEMM.map(orderEntity);
      orders.add(order);
    }
    return orders;
  }

  @Override
  public List<Order> getOrderByHospitalId(int hospitalId) {
    List<OrderEntity> orderEntities = orderRepository.findByHospitalId(hospitalId);
    List<Order> orders = new ArrayList<>();
    // for every orderEntity in orderEntities
    for (OrderEntity orderEntity : orderEntities) {
      Order order = OrderEMM.map(orderEntity);
      orders.add(order);
    }
    return orders;
  }

  @Override
  public List<Order> getOrderBySlotId(int slotId) {
    List<OrderEntity> orderEntities = orderRepository.findBySlotId(slotId);
    List<Order> orders = new ArrayList<>();
    // for every orderEntity in orderEntities
    for (OrderEntity orderEntity : orderEntities) {
      Order order = OrderEMM.map(orderEntity);
      orders.add(order);
    }
    return orders;
  }

  @Override
  public List<Order> getOrderByVisitDate(String visitDate) {
    List<OrderEntity> orderEntities = orderRepository.findByVisitDate(visitDate);
    List<Order> orders = new ArrayList<>();
    // for every orderEntity in orderEntities
    for (OrderEntity orderEntity : orderEntities) {
      Order order = OrderEMM.map(orderEntity);
      orders.add(order);
    }
    return orders;
  }
}
