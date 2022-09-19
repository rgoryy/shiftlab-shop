package com.example.shiftlabshop.repository.impl;

import com.example.shiftlabshop.repository.model.MonitorEntity;
import com.example.shiftlabshop.repository.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class MonitorRepo {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<MonitorEntity> rowMapper;
    //private String sql;
    @Autowired
    public MonitorRepo(JdbcTemplate jdbcTemplate, RowMapper<MonitorEntity> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }



    public List<MonitorEntity> selectALl() {
        final String sql = "select * from products join MONITORS on products.ID = MONITORS.MONITOR_ID;";
        return jdbcTemplate.query(sql, rowMapper);
    }


    public void insertDesktop(String serialNum, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock,
                              double diagonal){
        final String sql = "insert into products(serial_num, manufacturer, price, units, p_type) VALUES (?, ?, ?, ?, 2);\n" +
                "insert into monitors(monitor_id, diagonal) values (select id from products where serial_num = ?, ?);";
        jdbcTemplate.update(sql, serialNum, manufacturer, price, numOfProductUnitsInStock, serialNum, diagonal);

    }

    public ProductEntity getMonitorById(int id) {
        final String sql = "select * from products join desktops on products.id = laptops.laptop_id where id = ?;";
        return jdbcTemplate.query(sql, preparedStatement -> {preparedStatement.setInt(1, id);}
                ,rowMapper).get(0);
    }

    public void setDiagonalById(int id, double diagonal){
        //TODO
    }
}
