package com.example.shiftlabshop.controller;

import com.example.shiftlabshop.repository.model.*;
import com.example.shiftlabshop.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api")
public class TestController {

    @Autowired
    private ProductService productService;
    @Autowired
    private DesktopComputerService desktopService;
    @Autowired
    private MonitorService monitorService;
    @Autowired
    private HardDiskService hardDiskService;
    @Autowired
    private LaptopService laptopService;


    @GetMapping("get-all-desktops")
    public List<DesktopComputerEntity> getAllDesktops(){
        return this.desktopService.getAllDesktops();
    }

    @GetMapping("get-all-monitors")
    public List<MonitorEntity> getAllMonitors(){
        return this.monitorService.getAllMonitors();
    }

    @GetMapping("get-all-laptops")
    public List<LaptopEntity> getAllLaptops(){
        return this.laptopService.getAllLaptops();
    }

    @GetMapping("get-all-hard-disks")
    public List<HardDiskEntity> getAllHardDisks(){
        return this.hardDiskService.getAllHardDisks();
    }


    //добавление товара //TODO RequestBody
    @PostMapping("add-desktop")
    public void addDesktop(@RequestParam String serialNum, @RequestParam String manufacturer,
                           @RequestParam BigDecimal price, @RequestParam Integer numOfProductUnitsInStock,
                           @RequestParam int formFactor){
        this.desktopService.addDesktopComputer(serialNum, manufacturer, price, numOfProductUnitsInStock, formFactor);
    }

    @PostMapping("add-hard-disk")
    public void addMonitor(@RequestParam String serialNum,@RequestParam String manufacturer,
                           @RequestParam BigDecimal price,@RequestParam Integer numOfProductUnitsInStock,
                           @RequestParam int capacityInGB){
        this.hardDiskService.addHardDisk(serialNum, manufacturer, price, numOfProductUnitsInStock, capacityInGB);
    }

    @PostMapping("add-laptop")
    public void addLaptop(@RequestParam String serialNum, @RequestParam String manufacturer,
                          @RequestParam BigDecimal price, @RequestParam Integer numOfProductUnitsInStock,
                          @RequestParam int diagonal){
        this.laptopService.addLaptop(serialNum, manufacturer, price, numOfProductUnitsInStock, diagonal);
    }

    @PostMapping("add-monitor")
    public void addMonitor(@RequestParam String serialNum, @RequestParam String manufacturer,
                           @RequestParam BigDecimal price, @RequestParam Integer numOfProductUnitsInStock,
                           @RequestParam double diagonal){
        this.monitorService.addMonitor(serialNum, manufacturer, price, numOfProductUnitsInStock, diagonal);
    }

    @PostMapping("delete-by-id")
    public void deleteById(@RequestParam int id){
        this.productService.deleteById(id);
    }

    @GetMapping("get-product-by-id")//TODO
    public ProductEntity getProductById(@RequestParam int id){
        return this.productService.getProductTypeById(id);
    }
}
