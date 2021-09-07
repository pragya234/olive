package com.olive.olive.dbservice.repository;

import com.olive.olive.dbservice.entity.OrderEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
  OrderEntity findOrderByOrderId(int orderId);

  List<OrderEntity> findByCustomerId(int customerId);

  List<OrderEntity> findByHospitalId(int hospitalId);

  List<OrderEntity> findByDoctorId(int doctorId);

  List<OrderEntity> findBySlotId(int slotId);

  List<OrderEntity> findByVisitDate(String visitDate);
}
