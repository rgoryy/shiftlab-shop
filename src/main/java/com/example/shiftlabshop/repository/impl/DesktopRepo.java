package com.example.shiftlabshop.repository.impl;

import com.example.shiftlabshop.repository.model.DesktopComputerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class DesktopRepo {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<DesktopComputerEntity> rowMapper;


    @Autowired
    public DesktopRepo(JdbcTemplate jdbcTemplate, RowMapper<DesktopComputerEntity> rowMapper){
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }


    public List<DesktopComputerEntity> selectAll(){
        final String sql = "select * from products join desktops on products.ID = desktops.desktop_id;";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void insertDesktop(String serialNum, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock,
                              int formFactor){
        final String sql = "insert into products(serial_num, manufacturer, price, units, p_type) VALUES (?, ?, ?, ?, 4);\n" +
                "insert into desktops(desktop_id, form_factor) values (select id from products where serial_num = ?, ?);";
        jdbcTemplate.update(sql, serialNum, manufacturer, price, numOfProductUnitsInStock, serialNum, formFactor);
    }

    public DesktopComputerEntity getDesktopById(int id) {
        final String sql = "select * from products join desktops on products.id = desktops.desktop_id where id = ?;";
        return jdbcTemplate.query(sql, preparedStatement -> {preparedStatement.setInt(1, id);}
                ,rowMapper).get(0);
    }

    public void setFormFactorById(int id, int formFactor){
        //TODO
    }
}