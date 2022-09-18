package com.example.shiftlabshop.repository.model;

import java.math.BigDecimal;

public class HardDiskEntity extends ProductEntity{
    private Long capacityInGB;

    public HardDiskEntity() {
    }

    public HardDiskEntity(String productSerialNumber, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock, Long capacityInGB) {
        super(productSerialNumber, manufacturer, price, numOfProductUnitsInStock);
        this.capacityInGB = capacityInGB;
    }

    public Long getCapacityInGB() {
        return capacityInGB;
    }

    public void setCapacityInGB(Long capacityInGB) {
        this.capacityInGB = capacityInGB;
    }
}
