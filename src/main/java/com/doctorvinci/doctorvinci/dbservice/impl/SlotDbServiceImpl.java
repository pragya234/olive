package com.doctorvinci.doctorvinci.dbservice.impl;

import com.doctorvinci.doctorvinci.dbservice.SlotDbService;
import com.doctorvinci.doctorvinci.models.Slot;

import java.util.List;

public class SlotDbServiceImpl implements SlotDbService {
    @Override
    public List<Slot> getSlotByDoctorId(int doctorId) {
        return null;
    }

    @Override
    public List<Slot> getSlotsForDoctorIds(List<Integer> doctorIds) {
        return null;
    }
}
