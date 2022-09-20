package com.example.shiftlabshop.repository.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


@Repository
@Qualifier("productRepo")
public class ProductRepo {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Integer> rowMapper;

    public ProductRepo(JdbcTemplate jdbcTemplate, RowMapper<Integer> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }


    public void deleteById(int id){
        final String sql = "delete from products where id = ?;";
        this.jdbcTemplate.update(sql, ps -> { ps.setInt(1, id);
        });
    }

    public Integer getProductTypeById(int id){
        final String sql = "select p_type from products where id = ?;";
        return this.jdbcTemplate.queryForObject(sql, Integer.class, id);

    }

    public void setSerialNumById(int id, String serialNum){
        final String sql = "update products set serial_num = ? where id = ?;";
        this.jdbcTemplate.update(sql, ps -> {ps.setString(1, serialNum);
                                             ps.setInt(2, id);});
    }

    public void setManufacturerById(int id, String manufacturer){
        final String sql = "update products set manufacturer = ? where id = ?;";
        this.jdbcTemplate.update(sql, ps -> {ps.setString(1, manufacturer);
            ps.setInt(2, id);});
    }

    public void setPriceById(int id, BigDecimal price){
        final String sql = "update products set price = ? where id = ?;";
        this.jdbcTemplate.update(sql, ps -> {ps.setBigDecimal(1, price);
            ps.setInt(2, id);});
    }

    public void setUnitsById(int id, int units){
        final String sql = "update products set units = ? where id = ?;";
        this.jdbcTemplate.update(sql, ps -> {ps.setInt(1, units);
            ps.setInt(2, id);});
    }

    public void insertProductValues(String serialNum, String manufacturer, BigDecimal price,
                                    Integer numOfProductUnitsInStock, int pType) {
        final String sql = "insert into products(serial_num, manufacturer, price, units, p_type) VALUES (?, ?, ?, ?, ?);";
        this.jdbcTemplate.update(sql, ps -> {ps.setString(1,serialNum);
            ps.setString(2,manufacturer);
            ps.setBigDecimal(3,price);
            ps.setInt(4,numOfProductUnitsInStock);
            ps.setInt(5,pType);
        });
    }

    public boolean productExists(int id) {
        final String sql = "select * from products where id = ?;";
        return jdbcTemplate.query(sql, preparedStatement -> preparedStatement.setLong(1, id), rowMapper).size() > 0;
    }
}
