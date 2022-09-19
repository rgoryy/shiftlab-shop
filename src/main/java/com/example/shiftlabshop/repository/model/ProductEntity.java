package com.example.shiftlabshop.repository.model;

import java.math.BigDecimal;

public abstract class ProductEntity {
    private Integer id;
    private String productSerialNumber;
    private String manufacturer;
    private BigDecimal price;
    private Integer numOfProductUnitsInStock;
    private Integer type;



    public ProductEntity(){
    }

    public ProductEntity(String productSerialNumber, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock, Integer type) {
        this.productSerialNumber = productSerialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.numOfProductUnitsInStock = numOfProductUnitsInStock;
        this.type = type;
    }

    public String getProductSerialNumber() {
        return productSerialNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setProductSerialNumber(String productSerialNumber) {
        this.productSerialNumber = productSerialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNumOfProductUnitsInStock() {
        return numOfProductUnitsInStock;
    }

    public void setNumOfProductUnitsInStock(Integer numOfProductUnitsInStock) {
        this.numOfProductUnitsInStock = numOfProductUnitsInStock;
    }
}
