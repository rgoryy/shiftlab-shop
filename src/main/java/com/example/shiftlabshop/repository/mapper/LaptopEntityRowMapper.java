package com.example.shiftlabshop.repository.mapper;

import com.example.shiftlabshop.repository.model.LaptopEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LaptopEntityRowMapper implements RowMapper<LaptopEntity> {
    @Override
    public LaptopEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        LaptopEntity result = new LaptopEntity();
        result.setManufacturer(rs.getString("manufacturer"));
        result.setPrice(rs.getBigDecimal("price"));
        result.setNumOfProductUnitsInStock(rs.getInt("units"));
        result.setProductSerialNumber(rs.getString("serial_num"));
        result.setType(rs.getInt("p_type"));

        result.setDiagonal(rs.getInt("diagonal"));
        result.setId(rs.getInt("id"));
        return result;
    }
}
