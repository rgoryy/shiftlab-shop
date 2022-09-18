package com.example.shiftlabshop.repository.impl;

import com.example.shiftlabshop.repository.DesktopRepo;
import com.example.shiftlabshop.repository.model.DesktopComputerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DesktopRepoImpl implements DesktopRepo {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<DesktopComputerEntity> rowMapper;

    @Autowired
    public DesktopRepoImpl(JdbcTemplate jdbcTemplate, RowMapper<DesktopComputerEntity> rowMapper){
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<DesktopComputerEntity> selectAll(){
        final String sql = "select * from products join desktops on products.ID = desktops.desktop_id;";
        return jdbcTemplate.query(sql, rowMapper);
    }
}
