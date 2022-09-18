package com.example.shiftlabshop.repository.impl;

import com.example.shiftlabshop.repository.model.HardDiskEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class HardDiskRepoImpl{
    private JdbcTemplate jdbcTemplate;
    private RowMapper<HardDiskEntity> rowMapper;

}
