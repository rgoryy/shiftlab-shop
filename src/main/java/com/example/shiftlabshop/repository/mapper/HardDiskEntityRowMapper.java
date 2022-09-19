package com.example.shiftlabshop.repository.mapper;

import com.example.shiftlabshop.repository.model.HardDiskEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class HardDiskEntityRowMapper implements RowMapper<HardDiskEntity> {

    @Override
    public HardDiskEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        HardDiskEntity result = new HardDiskEntity();
        result.setManufacturer(rs.getString("manufacturer"));
        result.setPrice(rs.getBigDecimal("price"));
        result.setNumOfProductUnitsInStock(rs.getInt("units"));
        result.setProductSerialNumber(rs.getString("serial_num"));
        result.setType(rs.getInt("p_type"));

        result.setCapacityInGB(rs.getInt("capacity_gb"));
        result.setId(rs.getInt("id"));
        return result;
    }
}
