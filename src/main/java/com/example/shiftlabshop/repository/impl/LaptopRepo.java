package com.example.shiftlabshop.repository.impl;

import com.example.shiftlabshop.repository.model.LaptopEntity;
import com.example.shiftlabshop.repository.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class LaptopRepo {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<LaptopEntity> rowMapper;

    @Autowired
    public LaptopRepo(JdbcTemplate jdbcTemplate, RowMapper<LaptopEntity> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    public List<LaptopEntity> selectAll() {
        final String sql = "select * from products join LAPTOPS on products.ID = LAPTOPS.LAPTOP_ID;";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void insertLaptop(String serialNum, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock,
                               int diagonal){ //FIXME Byte, not int
        final String sql = "insert into products(serial_num, manufacturer, price, units, p_type) VALUES (?, ?, ?, ?, 3);\n" +
                "insert into laptops(laptop_id, diagonal) values (select id from products where serial_num = ?, ?);";
        jdbcTemplate.update(sql, serialNum, manufacturer, price, numOfProductUnitsInStock, serialNum, diagonal);
    }

    public ProductEntity getLaptopById(int id) {
        final String sql = "select * from products join laptops on products.id = laptops.laptop_id where id = ?;";
        return jdbcTemplate.query(sql, preparedStatement -> {preparedStatement.setInt(1, id);}
                ,rowMapper).get(0);
    }

    public void setDiagonalById(int id, int diagonal){
        //TODO
    }
}
