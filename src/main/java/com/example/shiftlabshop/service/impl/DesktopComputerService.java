package com.example.shiftlabshop.service.impl;

import com.example.shiftlabshop.repository.impl.DesktopRepo;
import com.example.shiftlabshop.repository.model.DesktopComputerEntity;
import com.example.shiftlabshop.service.impl.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DesktopComputerService{
    private DesktopRepo desktopRepo;
    @Autowired
    public DesktopComputerService(DesktopRepo desktopRepo) {
        this.desktopRepo = desktopRepo;
    }
    public List<DesktopComputerEntity> getAllDesktops() {
        return this.desktopRepo.selectAll();
    }

    public void addDesktopComputer(String serialNum, String manufacturer, BigDecimal price,
                                   Integer numOfProductUnitsInStock, int formFactor) {
        this.desktopRepo.insertDesktop(serialNum, manufacturer, price, numOfProductUnitsInStock, formFactor);
    }

    public void setFormFactorById(int id, int formFactor) throws ProductNotFoundException {
        if(!desktopRepo.productExists(id)){
            throw new ProductNotFoundException();
        }else {
            this.desktopRepo.setFormFactorById(id, formFactor);
        }
    }
}
