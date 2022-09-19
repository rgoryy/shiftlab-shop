package com.example.shiftlabshop.repository.mapper;

import com.example.shiftlabshop.repository.model.DesktopComputerEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DesktopComputerEntityRowMapper implements RowMapper<DesktopComputerEntity> {

    @Override
    public DesktopComputerEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        DesktopComputerEntity result = new DesktopComputerEntity();
        result.setManufacturer(rs.getString("manufacturer"));
        result.setPrice(rs.getBigDecimal("price"));
        result.setNumOfProductUnitsInStock(rs.getInt("units"));
        result.setProductSerialNumber(rs.getString("serial_num"));
        result.setType(rs.getInt("p_type"));

        result.setFormFactor(rs.getInt("form_factor"));
        result.setId(rs.getInt("id"));
        return result;
    }
}
