package com.example.shiftlabshop.repository.model;

import java.math.BigDecimal;

public class MonitorEntity extends ProductEntity{
    private double diagonal;

    public MonitorEntity() {}

    public MonitorEntity(String productSerialNumber, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock, Integer type, double diagonal) {
        super(productSerialNumber, manufacturer, price, numOfProductUnitsInStock, type);
        this.diagonal = diagonal;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }
}
