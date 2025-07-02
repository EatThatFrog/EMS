package org.harshita.ems.services;

import lombok.extern.slf4j.Slf4j;
import org.harshita.ems.dal.EmsRepo;
import org.harshita.ems.model.EmsItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmsService {

    @Autowired
    EmsRepo emsRepo;

    public EmsItem getEmsItems(String employeeId) {
        return emsRepo.getEmsItem(employeeId);
    }
}
