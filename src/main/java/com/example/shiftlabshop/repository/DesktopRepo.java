package com.example.shiftlabshop.repository;

import com.example.shiftlabshop.repository.model.DesktopComputerEntity;

import java.util.List;

public interface DesktopRepo {
    List<DesktopComputerEntity> selectAll();
}
