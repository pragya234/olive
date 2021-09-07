package com.doctorvinci.doctorvinci.dbservice.impl;

import com.doctorvinci.doctorvinci.dbservice.SlotDbService;
import com.doctorvinci.doctorvinci.dbservice.entity.SlotEntity;
import com.doctorvinci.doctorvinci.dbservice.mapper.SlotEMM;
import com.doctorvinci.doctorvinci.dbservice.repository.SlotRepository;
import com.doctorvinci.doctorvinci.models.Slot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class SlotDbServiceImpl implements SlotDbService {
  private final SlotRepository slotRepository;

  public SlotDbServiceImpl(SlotRepository slotRepository) {
    this.slotRepository = slotRepository;
  }

  @Override
  public List<Slot> getSlotByDoctorId(int doctorId) {
    List<Slot> slotList = new ArrayList<>();
    List<SlotEntity> slotEntityList = slotRepository.findByDoctorId(doctorId);
    for (SlotEntity slotEntity : slotEntityList) {
      Slot slot = SlotEMM.map(slotEntity);
      slotList.add(slot);
    }
    return slotList;
  }
  /*
  slotId1 belongs to doctorId1
  slotId2 belongs to doctorId2
  slotId3 belongs to doctorId1
  slotId4 belongs to doctorId3
  slotId5 belongs to doctorId1
  slotId6 belongs to doctorId1
  slotId7 belongs to doctorId2
  slotId8 belongs to doctorId4
  slotId9 belongs to doctorId4
  slotId10 belongs to doctorId4
  {
  this is an empty map which is there with us at the beginning of the for loop
  }
  -----------------------------------------------------
  {
  doctorId1-> [slotId1]
  }
  --------------------------------------------------------
  {
  doctorId1-> [slotId1]
  doctorId2-> [slotId2]
  }
  -----------------------------------------------------------
  {
  doctorId1-> [slotId1, slotId3]
  doctorId2-> [slotId2]
  }
  ------------------------------------------------------------
  .
  .
  .
  {
  doctorId1->[slotId1, slotId3, slotId5, slotId6]
  doctorId2->[slotId2, slotId7]
  doctorId3->[slotId4]
  doctorId4->[slotId8, slotId9, slotId10]
  }

   */
  @Override
  public Map<Integer, List<Slot>> getSlotsForDoctorIds(List<Integer> doctorIds) {
    Map<Integer, List<Slot>> doctorIdToSlots = new HashMap<>();
    List<SlotEntity> slotEntityList = slotRepository.findByDoctorIdIn(doctorIds);
    for (SlotEntity slotEntity : slotEntityList) {
      Slot slot = SlotEMM.map(slotEntity);
      if (doctorIdToSlots.containsKey(slotEntity.getDoctorId())) {
        doctorIdToSlots.get(slotEntity.getDoctorId()).add(slot);
        // doctorIdToSlots.get(doctorId1).add(slot);
        // [slotId1].add(slot)
        // [slotId1, slotId3]
      } else {
        List<Slot> doctorSlot = new ArrayList<>();
        doctorIdToSlots.put(slotEntity.getDoctorId(), doctorSlot);
        doctorSlot.add(slot);
      }
    }
    return doctorIdToSlots;
  }

  @Override
  public void saveSlot(List<Slot> slots, int doctorId) {
    List<SlotEntity> slotEntities = new ArrayList<>();
    for (Slot slot : slots) {
      SlotEntity slotEntity = SlotEMM.map(slot);
      slotEntity.setDoctorId(doctorId);
      slotEntities.add(slotEntity);
    }
    slotRepository.saveAll(slotEntities);
  }

  @Override
  public void saveSlots(Map<Integer, List<Slot>> doctorIdToSlots) {
    List<SlotEntity> slotEntities = new ArrayList<>();
    for (Integer doctorId : doctorIdToSlots.keySet()) {
      for (Slot slot : doctorIdToSlots.get(doctorId)) {
        SlotEntity slotEntity = SlotEMM.map(slot);
        slotEntity.setDoctorId(doctorId);
        slotEntities.add(slotEntity);
      }
      slotRepository.saveAll(slotEntities);
    }
  }
}
