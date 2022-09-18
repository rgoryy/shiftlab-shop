package com.example.shiftlabshop.repository.impl;

import com.example.shiftlabshop.repository.model.LaptopEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class LaptopRepoImpl {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<LaptopEntity> rowMapper;
}
