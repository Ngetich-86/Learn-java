package com.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DBTestController {
    @Autowired // Injecting the Jdbc template to access the database
    private JdbcTemplate jdbcTemplate; // Spring's database access helper

    @GetMapping("/dbtest")
    public String dbTest() {
        //test database connection
        String sql = "SELECT 1";
        try {
            Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
            return "Database connection successful, result: " + result;
        } catch (Exception e) {
            return "Database connection failed: " + e.getMessage();
        }
    }

}