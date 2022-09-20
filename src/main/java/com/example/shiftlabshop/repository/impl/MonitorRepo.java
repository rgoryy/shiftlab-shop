package com.example.shiftlabshop.repository.impl;

import com.example.shiftlabshop.repository.model.MonitorEntity;
import com.example.shiftlabshop.repository.model.ProductEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class MonitorRepo extends ProductRepo{
    private JdbcTemplate jdbcTemplate;
    private RowMapper<MonitorEntity> rowMapper;
    private final static int pType = 2;

    public MonitorRepo(JdbcTemplate jdbcTemplate, RowMapper<Integer> rowMapper, JdbcTemplate jdbcTemplate1,
                       RowMapper<MonitorEntity> rowMapper1) {
        super(jdbcTemplate, rowMapper);
        this.jdbcTemplate = jdbcTemplate1;
        this.rowMapper = rowMapper1;
    }

    public List<MonitorEntity> selectALl() {
        final String sql = "select * from products join MONITORS on products.ID = MONITORS.MONITOR_ID;";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void insertMonitor(String serialNum, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock,
                              double diagonal){
        insertProductValues(serialNum, manufacturer, price, numOfProductUnitsInStock, pType);
        final String sql = "insert into monitors(monitor_id, diagonal) values (select id from products where serial_num = ?, ?);";
        this.jdbcTemplate.update(sql, ps -> {ps.setString(1, serialNum);
            ps.setDouble(2, diagonal);});
    }

    public ProductEntity getMonitorById(int id) {
        final String sql = "select * from products join monitors on products.id = monitors.monitor_id where id = ?;";
        return jdbcTemplate.query(sql, ps -> {ps.setInt(1, id);}
                ,rowMapper).get(0);
    }

    public void setDiagonalById(int id, double diagonal){
        final String sql = "update laptops set diagonal = ? where laptop_id = ?;";
        this.jdbcTemplate.update(sql, ps -> {ps.setDouble(1, diagonal);
            ps.setInt(2, id);});
    }
}
