package com.example.shiftlabshop.service.impl;

import com.example.shiftlabshop.repository.DesktopRepo;
import com.example.shiftlabshop.repository.impl.DesktopRepoImpl;
import com.example.shiftlabshop.repository.model.DesktopComputerEntity;
import com.example.shiftlabshop.service.DesktopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesktopServiceImpl implements DesktopService {
    public DesktopRepo desktopRepo;

    @Autowired
    public DesktopServiceImpl(DesktopRepo desktopRepo) {
        this.desktopRepo = desktopRepo;
    }

    @Override
    public List<DesktopComputerEntity> getAllDesktops() {
        return this.desktopRepo.selectAll();
    }
}
