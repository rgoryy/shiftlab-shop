package com.example.shiftlabshop.repository.impl;

import com.example.shiftlabshop.repository.model.HardDiskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Qualifier("hardDiskRepo")
public class HardDiskRepo extends ProductRepo{
    private JdbcTemplate jdbcTemplate;

    private RowMapper<HardDiskEntity> rowMapper;

    private final static int pType = 3;

    public HardDiskRepo(JdbcTemplate jdbcTemplate, RowMapper<Integer> rowMapper, JdbcTemplate jdbcTemplate1,
                        RowMapper<HardDiskEntity> rowMapper1) {
        super(jdbcTemplate, rowMapper);
        this.jdbcTemplate = jdbcTemplate1;
        this.rowMapper = rowMapper1;
    }

    public List<HardDiskEntity> selectAll() {
        final String sql = "select * from products join hard_disks on products.ID = hard_disks.hard_disk_id;";
        return jdbcTemplate.query(sql, rowMapper);
    }


    public void insertHardDisk(String serialNum, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock,
                               int capacityInGB){
        insertProductValues(serialNum, manufacturer, price, numOfProductUnitsInStock, pType);
        final String sql = "insert into hard_disks(hard_disk_id, capacity_gb) values (select id from products where serial_num = ?, ?);";
        this.jdbcTemplate.update(sql, ps -> {ps.setString(1, serialNum);
                                             ps.setInt(2, capacityInGB);});
    }

    public HardDiskEntity getHardDiskByID(int id) {
        final String sql = "select * from products join hard_disks on products.id = hard_disks.hard_disk_id where id = ?;";
        return jdbcTemplate.query(sql, ps -> {ps.setInt(1, id);}
                ,rowMapper).get(0);
    }

    public void setCapacityInGbById(int id, int capacityInGb){
        final String sql = "update hard_disks set capacity_gb = ? where hard_disk_id = ?;";
        this.jdbcTemplate.update(sql, ps -> {ps.setInt(1, capacityInGb);
            ps.setInt(2, id);});
    }
}
