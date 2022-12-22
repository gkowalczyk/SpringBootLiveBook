package com.example.springbootlivebook.JDBC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {

    @Test
    void testConnect() {
        Config config = new Config();
        config.getJdbcTemplate();
        config.dataSource();
    }
}