package com.example.shiftlabshop.repository.model;

import java.math.BigDecimal;

public class DesktopComputerEntity extends ProductEntity{
    private int formFactor;

    public DesktopComputerEntity() {
    }

    public DesktopComputerEntity(String productSerialNumber, String manufacturer, BigDecimal price,
                                 Integer numOfProductUnitsInStock, Integer type, int formFactor) {
        super(productSerialNumber, manufacturer, price, numOfProductUnitsInStock, type);
        this.formFactor = formFactor;
    }

    public int getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(int formFactor) {
        this.formFactor = formFactor;
    }
}
