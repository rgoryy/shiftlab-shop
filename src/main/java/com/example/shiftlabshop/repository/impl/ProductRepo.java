package com.example.shiftlabshop.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class ProductRepo {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Integer> rowMapper;

    public ProductRepo(JdbcTemplate jdbcTemplate, RowMapper<Integer> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }


    public void deleteById(int id){
        final String sql = "delete from products where id = ?;";
        this.jdbcTemplate.update(sql, preparedStatement -> { preparedStatement.setInt(1, id);
        });
    }

    public Integer getProductTypeById(int id){
        final String sql = "select p_type from products where id = ?;";
        return this.jdbcTemplate.query(sql,preparedStatement -> { preparedStatement.setInt(1, id);
        }, rowMapper).get(0);
    }

    public void setSerialNumById(int id, String serialNum){
        //TODO
    }

    public void setManufacturerById(int id, String manufacturer){
        //TODO
    }

    public void setPriceById(int id, BigDecimal price){
        //TODO
    }

    public void setUnitsById(int id, int units){
        //TODO
    }
    public void setTypeById(int id, int type){
        //TODO
    }

}
