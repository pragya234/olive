package com.doctorvinci.doctorvinci.dbservice;
import com.doctorvinci.doctorvinci.models.Order;
import java.util.List;

public interface OrderDbService {
    Order getOrderByOrderId(int orderId);
    List<Order> getOrderByCustomerId(int customerId);
    List<Order> getOrderByDoctorId(int doctorId);
    List<Order> getOrderByHospitalId(int hospitalId);
    List<Order> getOrderBySlotId(int slotId);
    List<Order> getOrderByVisitDate(String visitDate);
}
