package com.example.shiftlabshop.service.impl;

import com.example.shiftlabshop.repository.impl.*;
import com.example.shiftlabshop.repository.model.ProductEntity;
import com.example.shiftlabshop.service.impl.exceptions.ProductNotFoundException;
import com.example.shiftlabshop.service.impl.exceptions.UnknownException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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


    public void deleteById(int id) throws ProductNotFoundException {
        if(!productRepo.productExists(id)){
            throw new ProductNotFoundException();
        }else {
            this.productRepo.deleteById(id);
        }
    }

    public ProductEntity getProductTypeById(int id) throws ProductNotFoundException, UnknownException {
        if(!productRepo.productExists(id)){
            throw new ProductNotFoundException();
        }else {
            int type = productRepo.getProductTypeById(id);
            switch (type) {
                case (1):
                    return laptopRepo.getLaptopById(id);
                case (2):
                    return monitorRepo.getMonitorById(id);
                case (3):
                    return hardDiskRepo.getHardDiskByID(id);
                case (4):
                    return desktopRepo.getDesktopById(id);
                default:
                    throw new UnknownException();
            }
        }
    }

    public void setSerialNumById(int id, String serialNum) throws ProductNotFoundException {
        if(!productRepo.productExists(id)){
            throw new ProductNotFoundException();
        }else {
            this.productRepo.setSerialNumById(id, serialNum);
        }
    }

    public void setManufacturerById(int id, String manufacturer) throws ProductNotFoundException {
        if(!productRepo.productExists(id)){
            throw new ProductNotFoundException();
        }else {
        this.productRepo.setManufacturerById(id, manufacturer);
        }
    }

    public void setPriceById(int id, BigDecimal price) throws ProductNotFoundException {
        if(!productRepo.productExists(id)){
            throw new ProductNotFoundException();
        }else {
            this.productRepo.setPriceById(id, price);
        }
    }

    public void setUnitsById(int id, int units) throws ProductNotFoundException {
        if(!productRepo.productExists(id)){
            throw new ProductNotFoundException();
        }else {
            this.productRepo.setUnitsById(id, units);
        }
    }
}
