package com.example.shiftlabshop.controller;

import com.example.shiftlabshop.repository.impl.DesktopRepoImpl;
import com.example.shiftlabshop.repository.model.DesktopComputerEntity;
import com.example.shiftlabshop.service.DesktopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("test/api")
public class TestController {
    @Autowired
    private DesktopService desktopService;

    @GetMapping("get-all-desktops")
    public List<DesktopComputerEntity> getAllDesktops(){
        System.out.println("Bello");
        return this.desktopService.getAllDesktops();
    }
}
