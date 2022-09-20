package com.example.shiftlabshop.service.impl;

import com.example.shiftlabshop.repository.impl.HardDiskRepo;
import com.example.shiftlabshop.repository.model.HardDiskEntity;
import com.example.shiftlabshop.service.impl.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class HardDiskService{
    private HardDiskRepo hardDiskRepo;
    @Autowired
    public HardDiskService(HardDiskRepo hardDiskRepo) {
        this.hardDiskRepo = hardDiskRepo;
    }
    public List<HardDiskEntity> getAllHardDisks() {
        return this.hardDiskRepo.selectAll();
    }

    public void addHardDisk(String serialNum, String manufacturer, BigDecimal price,
                            Integer numOfProductUnitsInStock, int capacityInGB) {
        this.hardDiskRepo.insertHardDisk(serialNum, manufacturer, price, numOfProductUnitsInStock, capacityInGB);
    }

    public void setCapacityInGbById(int id, int capacityInGb) throws ProductNotFoundException {
        if(!hardDiskRepo.productExists(id)){
            throw new ProductNotFoundException();
        }else {
            this.hardDiskRepo.setCapacityInGbById(id, capacityInGb);
        }
    }
}
