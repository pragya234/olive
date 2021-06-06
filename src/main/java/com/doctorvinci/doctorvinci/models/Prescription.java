package com.doctorvinci.doctorvinci.models;

import lombok.Data;

import java.util.List;

@Data
public class Prescription {
    private int bookingId;
    private List<Medicine> medicines;
}
