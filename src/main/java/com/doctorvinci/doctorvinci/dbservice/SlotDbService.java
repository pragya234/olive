package com.doctorvinci.doctorvinci.dbservice;

import com.doctorvinci.doctorvinci.models.Slot;

import java.util.List;

public interface SlotDbService {
List<Slot> getSlotByDoctorId(int doctorId);
List<Slot> getSlotsForDoctorIds(List<Integer> doctorIds);
}
