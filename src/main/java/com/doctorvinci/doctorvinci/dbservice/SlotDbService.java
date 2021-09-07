package com.doctorvinci.doctorvinci.dbservice;

import com.doctorvinci.doctorvinci.models.Slot;
import java.util.List;
import java.util.Map;

public interface SlotDbService {
  List<Slot> getSlotByDoctorId(int doctorId);

  Map<Integer, List<Slot>> getSlotsForDoctorIds(List<Integer> doctorIds);

  void saveSlot(List<Slot> slots, int doctorId);

  void saveSlots(Map<Integer, List<Slot>> doctorIdToSlots);
}
