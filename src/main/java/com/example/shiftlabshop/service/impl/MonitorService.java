package com.example.shiftlabshop.service.impl;

import com.example.shiftlabshop.repository.impl.MonitorRepo;
import com.example.shiftlabshop.repository.model.MonitorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MonitorService{
    private MonitorRepo monitorRepo;

    @Autowired
    public MonitorService(MonitorRepo monitorRepo) {
        this.monitorRepo = monitorRepo;
    }


    public List<MonitorEntity> getAllMonitors() {
        return this.monitorRepo.selectALl();
    }


    public void addMonitor(String serialNum, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock, double diagonal) {
        this.monitorRepo.insertDesktop(serialNum, manufacturer, price, numOfProductUnitsInStock, diagonal);
    }
}
