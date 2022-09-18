package com.example.shiftlabshop.repository.model;

import java.math.BigDecimal;

public class LaptopEntity extends ProductEntity{
    private int diagonal;
    public LaptopEntity() {
    }

    public LaptopEntity(String productSerialNumber, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock, int diagonal) {
        super(productSerialNumber, manufacturer, price, numOfProductUnitsInStock);
        this.diagonal = diagonal;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    //TODO USE ENUM
    /*private LaptopDiag diagonal;

    public LaptopEntity() {
    }

    public LaptopEntity(String productSerialNumber, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock, LaptopDiag diagonal) {
        super(productSerialNumber, manufacturer, price, numOfProductUnitsInStock);
        this.diagonal = diagonal;
    }

    public LaptopDiag getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(LaptopDiag diagonal) {
        this.diagonal = diagonal;
    }*/
}
