package com.example.shiftlabshop.repository.model.enums;

public enum LaptopDiag {
    THIRTEEN(1),
    FOURTEEN(2),
    FIFTEEN(3),
    SEVENTEEN(4);

    private int value;
    LaptopDiag(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
