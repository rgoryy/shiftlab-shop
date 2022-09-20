package com.example.shiftlabshop.service.impl;

import com.example.shiftlabshop.repository.impl.LaptopRepo;
import com.example.shiftlabshop.repository.model.LaptopEntity;
import com.example.shiftlabshop.service.impl.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LaptopService{
    private LaptopRepo laptopRepo;
    @Autowired
    public LaptopService(LaptopRepo laptopRepo) {
        this.laptopRepo = laptopRepo;
    }
    public List<LaptopEntity> getAllLaptops() {
        return this.laptopRepo.selectAll();
    }


    public void addLaptop(String serialNum, String manufacturer, BigDecimal price,
                          Integer numOfProductUnitsInStock, int diagonal) {
        this.laptopRepo.insertLaptop(serialNum, manufacturer, price, numOfProductUnitsInStock, diagonal);
    }

    public void setDiagonalById(int id, int diagonal) throws ProductNotFoundException {
        if(!laptopRepo.productExists(id)){
            throw new ProductNotFoundException();
        }else {
            this.laptopRepo.setDiagonalById(id, diagonal);
        }
    }
}
