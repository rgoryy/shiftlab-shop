package com.example.shiftlabshop.repository.mapper;

import com.example.shiftlabshop.repository.model.MonitorEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MonitorEntityRowMapper implements RowMapper<MonitorEntity> {
    @Override
    public MonitorEntity mapRow(ResultSet rs, int rowNum) throws SQLException{
        MonitorEntity result = new MonitorEntity();
        result.setManufacturer(rs.getString("manufacturer"));
        result.setPrice(rs.getBigDecimal("price"));
        result.setNumOfProductUnitsInStock(rs.getInt("units"));
        result.setProductSerialNumber(rs.getString("serial_num"));

        result.setDiagonal(rs.getInt("diagonal"));
        return result;
    }
}
