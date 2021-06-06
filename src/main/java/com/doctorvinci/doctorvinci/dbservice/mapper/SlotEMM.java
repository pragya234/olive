package com.doctorvinci.doctorvinci.dbservice.mapper;

import com.doctorvinci.doctorvinci.dbservice.entity.SlotEntity;
import com.doctorvinci.doctorvinci.models.Slot;

public class SlotEMM {
  public static SlotEntity map(Slot slot) {
    SlotEntity slotEntity = new SlotEntity();
    slotEntity.setSlotStartTime(slotEntity.getSlotStartTime());
    slotEntity.setSlotEndTime(slot.getSlotEndTime());
    slotEntity.setNumberOfPatientPerSlot(slot.getNumberOfPatientPerSlot());
    return slotEntity;
  }

  public static Slot map(SlotEntity slotEntity) {
    Slot slot = new Slot();
    slot.setSlotId(slot.getSlotId());
    slot.setSlotStartTime(slotEntity.getSlotStartTime());
    slot.setSlotEndTime(slot.getSlotEndTime());
    slot.setNumberOfPatientPerSlot(slot.getNumberOfPatientPerSlot());
    return slot;
  }
}
