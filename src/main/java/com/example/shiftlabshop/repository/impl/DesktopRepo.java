package com.example.shiftlabshop.repository.impl;

import com.example.shiftlabshop.repository.model.DesktopComputerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Qualifier("desktopRepo")
public class DesktopRepo extends ProductRepo{
    private JdbcTemplate jdbcTemplate;

    private RowMapper<DesktopComputerEntity> rowMapper;
    private final static int pType = 4;
    @Autowired
    public DesktopRepo(JdbcTemplate jdbcTemplate, RowMapper<Integer> rowMapper, JdbcTemplate jdbcTemplate1,
                       RowMapper<DesktopComputerEntity> rowMapper1) {
        super(jdbcTemplate, rowMapper);
        this.jdbcTemplate = jdbcTemplate1;
        this.rowMapper = rowMapper1;
    }

    public List<DesktopComputerEntity> selectAll(){
        final String sql = "select * from products join desktops on products.ID = desktops.desktop_id;";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void insertDesktop(String serialNum, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock,
                              int formFactor){
        insertProductValues(serialNum, manufacturer, price, numOfProductUnitsInStock, pType);
        final String sql = "insert into desktops(desktop_id, form_factor) values (select id from products where serial_num = ?, ?);";
        this.jdbcTemplate.update(sql, ps -> {ps.setString(1, serialNum);
                                             ps.setInt(2, formFactor);});
    }

    public DesktopComputerEntity getDesktopById(int id) {
        final String sql = "select * from products join desktops on products.id = desktops.desktop_id where id = ?;";
        return jdbcTemplate.query(sql, ps -> {ps.setInt(1, id);}
                ,rowMapper).get(0);
    }

    public void setFormFactorById(int id, int formFactor){
        final String sql = "update desktops set form_factor = ? where DESKTOP_ID = ?;";
        this.jdbcTemplate.update(sql, ps -> {ps.setInt(1, formFactor);
            ps.setInt(2, id);});
    }
}
