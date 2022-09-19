package com.example.shiftlabshop.repository.model;

import java.math.BigDecimal;

public class HardDiskEntity extends ProductEntity{
    private int capacityInGB;

    public HardDiskEntity() {
    }

    public HardDiskEntity(String productSerialNumber, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock, Integer type, int capacityInGB) {
        super(productSerialNumber, manufacturer, price, numOfProductUnitsInStock, type);
        this.capacityInGB = capacityInGB;
    }

    public int getCapacityInGB() {
        return capacityInGB;
    }

    public void setCapacityInGB(int capacityInGB) {
        this.capacityInGB = capacityInGB;
    }
}
