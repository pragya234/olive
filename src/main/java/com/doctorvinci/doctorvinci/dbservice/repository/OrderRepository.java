package com.doctorvinci.doctorvinci.dbservice.repository;

import com.doctorvinci.doctorvinci.dbservice.entity.OrderEntity;
import com.doctorvinci.doctorvinci.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    OrderEntity findOrderByOrderId(int orderId);
    List<OrderEntity> findByCustomerId(int customerId);

    List<OrderEntity> findByHospitalId(int hospitalId);

    List<OrderEntity> findByDoctorId(int doctorId);

    List<OrderEntity> findBySlotId(int slotId);

    List<OrderEntity> findByVisitDate(String visitDate);

}
