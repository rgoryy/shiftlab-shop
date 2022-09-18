package com.example.shiftlabshop.repository.model;

import java.math.BigDecimal;

public class DesktopComputerEntity extends ProductEntity{
    private int formFactor; //range 1-3

    public DesktopComputerEntity() {
    }

    public DesktopComputerEntity(String productSerialNumber, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock, int formFactor) {
        super(productSerialNumber, manufacturer, price, numOfProductUnitsInStock);
        this.formFactor = formFactor;
    }

    public int getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(int formFactor) {
        this.formFactor = formFactor;
    }

    //TODO USE ENUM
    /*private DesktopComputerFormFactor formFactor;

    public DesktopComputerEntity() {
    }

    public DesktopComputerEntity(String productSerialNumber, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock, DesktopComputerFormFactor formFactor) {
        super(productSerialNumber, manufacturer, price, numOfProductUnitsInStock);
        this.formFactor = formFactor;
    }

    public DesktopComputerFormFactor getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(DesktopComputerFormFactor formFactor) {
        this.formFactor = formFactor;
    }*/

}
