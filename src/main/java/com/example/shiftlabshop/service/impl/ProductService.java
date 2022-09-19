package com.example.shiftlabshop.service.impl;

import com.example.shiftlabshop.repository.impl.*;
import com.example.shiftlabshop.repository.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ProductService {
    private ProductRepo productRepo;
    private LaptopRepo laptopRepo;
    private MonitorRepo monitorRepo;
    private HardDiskRepo hardDiskRepo;
    private DesktopRepo desktopRepo;

    @Autowired
    public ProductService(ProductRepo productRepo, LaptopRepo laptopRepo, MonitorRepo monitorRepo,
                          HardDiskRepo hardDiskRepo, DesktopRepo desktopRepo) {
        this.productRepo = productRepo;
        this.laptopRepo = laptopRepo;
        this.monitorRepo = monitorRepo;
        this.hardDiskRepo = hardDiskRepo;
        this.desktopRepo = desktopRepo;
    }


    public void deleteById(int id){
        this.productRepo.deleteById(id);
    }

    public ProductEntity getProductTypeById(int id){
        int type = productRepo.getProductTypeById(id);
        switch (type) {
            case(1):
                return laptopRepo.getLaptopById(id);
            case(2):
                return monitorRepo.getMonitorById(id);
            case(3):
                return hardDiskRepo.getHardDiskByID(id);
            case(4):
                return desktopRepo.getDesktopById(id);
            default:
                //TODO
                return null;
        }
    }
}
