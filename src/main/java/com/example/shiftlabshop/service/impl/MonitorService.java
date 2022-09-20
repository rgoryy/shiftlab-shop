package com.example.shiftlabshop.service.impl;

import com.example.shiftlabshop.repository.impl.MonitorRepo;
import com.example.shiftlabshop.repository.model.MonitorEntity;
import com.example.shiftlabshop.service.impl.exceptions.ProductNotFoundException;
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

    public void addMonitor(String serialNum, String manufacturer, BigDecimal price,
                           Integer numOfProductUnitsInStock, double diagonal) {
        this.monitorRepo.insertMonitor(serialNum, manufacturer, price, numOfProductUnitsInStock, diagonal);
    }

    public void setDiagonalById(int id, double diagonal) throws ProductNotFoundException {
        if(!monitorRepo.productExists(id)){
            throw new ProductNotFoundException();
        }else {
            this.monitorRepo.setDiagonalById(id, diagonal);
        }
    }
}
