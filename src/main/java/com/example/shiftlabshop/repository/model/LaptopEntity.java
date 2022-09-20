package com.example.shiftlabshop.repository.model;

import java.math.BigDecimal;

public class LaptopEntity extends ProductEntity{
    private int diagonal;
    public LaptopEntity() {
    }

    public LaptopEntity(String productSerialNumber, String manufacturer, BigDecimal price,
                        Integer numOfProductUnitsInStock, Integer type, int diagonal) {
        super(productSerialNumber, manufacturer, price, numOfProductUnitsInStock, type);
        this.diagonal = diagonal;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }
}
