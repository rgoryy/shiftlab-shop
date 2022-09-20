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
public class LaptopRepo extends ProductRepo{
    private JdbcTemplate jdbcTemplate;
    private RowMapper<LaptopEntity> rowMapper;

    private final static int pType = 1;

    public LaptopRepo(JdbcTemplate jdbcTemplate, RowMapper<Integer> rowMapper,
                      JdbcTemplate jdbcTemplate1, RowMapper<LaptopEntity> rowMapper1) {
        super(jdbcTemplate, rowMapper);
        this.jdbcTemplate = jdbcTemplate1;
        this.rowMapper = rowMapper1;
    }

    public List<LaptopEntity> selectAll() {
        final String sql = "select * from products join LAPTOPS on products.ID = LAPTOPS.LAPTOP_ID;";
        return jdbcTemplate.query(sql, rowMapper);
    }

    /*public void insertLaptop(String serialNum, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock,
                               int diagonal){ //FIXME Byte, not int
        final String sql = "insert into products(serial_num, manufacturer, price, units, p_type) VALUES (?, ?, ?, ?, 3);\n" +
                "insert into laptops(laptop_id, diagonal) values (select id from products where serial_num = ?, ?);";
        jdbcTemplate.update(sql, serialNum, manufacturer, price, numOfProductUnitsInStock, serialNum, diagonal);
    }*/

    public void insertLaptop(String serialNum, String manufacturer, BigDecimal price, Integer numOfProductUnitsInStock,
                             int diagonal){
        insertProductValues(serialNum, manufacturer, price, numOfProductUnitsInStock, pType);
        final String sql = "insert into laptops(laptop_id, diagonal) values (select id from products where serial_num = ?, ?);";
        this.jdbcTemplate.update(sql, ps -> {ps.setString(1, serialNum);
            ps.setInt(2, diagonal);});
    }


    public ProductEntity getLaptopById(int id) {
        final String sql = "select * from products join laptops on products.id = laptops.laptop_id where id = ?;";
        return jdbcTemplate.query(sql, ps -> {ps.setInt(1, id);}
                ,rowMapper).get(0);
    }

    public void setDiagonalById(int id, int diagonal){
        final String sql = "update laptops set diagonal = ? where laptop_id = ?;";
        this.jdbcTemplate.update(sql, ps -> {ps.setInt(1, diagonal);
            ps.setInt(2, id);});
    }
}
