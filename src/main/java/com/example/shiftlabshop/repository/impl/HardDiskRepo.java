package com.example.shiftlabshop.repository.impl;

import com.example.shiftlabshop.repository.model.HardDiskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class HardDiskRepo {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<HardDiskEntity> rowMapper;

    @Autowired
    public HardDiskRepo(JdbcTemplate jdbcTemplate, RowMapper<HardDiskEntity> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }


    public List<HardDiskEntity> selectAll() {
        final String sql = "select * from products join hard_disks on products.ID = hard_disks.hard_disk_id;";
        return jdbcTemplate.query(sql, rowMapper);
    }


    public void insertHardDisk(String serialNum, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock,
                              int capacityInGB){
        final String sql = "insert into products(serial_num, manufacturer, price, units, p_type) VALUES (?, ?, ?, ?, 3);\n" +
                "insert into hard_disks(hard_disk_id, capacity_gb) values (select id from products where serial_num = ?, ?);";
        jdbcTemplate.update(sql, serialNum, manufacturer, price, numOfProductUnitsInStock, serialNum, capacityInGB);
    }

    public HardDiskEntity getHardDiskByID(int id) {
        final String sql = "select * from products join hard_disks on products.id = hard_disks.hard_disk_id where id = ?;";
        return jdbcTemplate.query(sql, preparedStatement -> {preparedStatement.setInt(1, id);}
                ,rowMapper).get(0);
    }

    public void setCapacityInGbById(int id, int capacity){
        //TODO
    }
}
