package com.example.shiftlabshop.controller;

import com.example.shiftlabshop.repository.model.*;
import com.example.shiftlabshop.service.impl.*;
import com.example.shiftlabshop.service.impl.exceptions.ProductNotFoundException;
import com.example.shiftlabshop.service.impl.exceptions.UnknownException;
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


    //TODO RequestBody
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
    public void deleteById(@RequestParam int id) throws ProductNotFoundException {
        this.productService.deleteById(id);
    }

    @GetMapping("get-product-by-id")
    public ProductEntity getProductById(@RequestParam int id) throws ProductNotFoundException, UnknownException {
        return this.productService.getProductTypeById(id);
    }

    //редактирование товара
    @PostMapping("set-serial-num-by-id")
    public void setSerialNumById(int id, String serialNum) throws ProductNotFoundException {
        this.productService.setSerialNumById(id, serialNum);
    }

    @PostMapping("set-manufacturer-by-id")
    public void setManufacturerById(int id, String manufacturer) throws ProductNotFoundException {
        this.productService.setManufacturerById(id, manufacturer);
    }

    @PostMapping("set-price-by-id")
    public void setPriceById(int id, BigDecimal price) throws ProductNotFoundException {
        this.productService.setPriceById(id, price);
    }

    @PostMapping("set-units-by-id")
    public void setUnitsById(int id, int units) throws ProductNotFoundException {
        this.productService.setUnitsById(id, units);
    }

    @PostMapping("desktops/set-form-factor")
    public void setFormFactorById(int id, int formFactor) throws ProductNotFoundException {
        this.desktopService.setFormFactorById(id, formFactor);
    }

    @PostMapping("hard-disks/set-capacity")
    public void setCapacityInGbById(int id, int capacityInGb) throws ProductNotFoundException {
        this.hardDiskService.setCapacityInGbById(id, capacityInGb);
    }

    @PostMapping("laptops/set-diagonal")
    public void setLaptopDiagonalById(int id, int diagonal) throws ProductNotFoundException {
        this.laptopService.setDiagonalById(id, diagonal);
    }

    @PostMapping("monitors/set-diagonal")
    public void setMonitorDiagonalById(int id, double diagonal)throws ProductNotFoundException {
        this.monitorService.setDiagonalById(id, diagonal);
    }
}
