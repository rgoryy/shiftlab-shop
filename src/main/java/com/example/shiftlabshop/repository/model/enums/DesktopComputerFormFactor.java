package com.example.shiftlabshop.repository.model.enums;

public enum DesktopComputerFormFactor {
    DESKTOP(1),
    NETTOP(2),
    MONOBLOCK(3);

    private Integer translation;
    DesktopComputerFormFactor(Integer intoInt){
        this.translation = intoInt;
    }
}
