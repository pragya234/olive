package com.doctorvinci.doctorvinci.dbservice.repository;

import com.doctorvinci.doctorvinci.dbservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    List<OrderEntity> getOrderByCustomerId(int customerId);

    List<OrderEntity> getOrderByHospitalId(int hospitalId);

    List<OrderEntity> getOrderByDoctorId(int doctorId);

}
