package com.example.shiftlabshop.repository.impl;

import com.example.shiftlabshop.repository.model.MonitorEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MonitorRepoImpl {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<MonitorEntity> rowMapper;
}
