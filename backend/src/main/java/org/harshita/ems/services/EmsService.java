package org.harshita.ems.services;

import org.harshita.ems.dal.EmsRepo;
import org.harshita.ems.model.EmsItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmsService {

    @Autowired
    EmsRepo emsRepo;

    public EmsItem getEmsItems(String employeeId) {
        return emsRepo.getEmsItem(employeeId);
    }
}
