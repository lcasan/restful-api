package com.restfulapi.restful_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInizializer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        createTables();
    }

    private void createTables() {
        String createTableSql = """
                    CREATE TABLE IF NOT EXISTS products (
                        code SERIAL PRIMARY KEY UNIQUE NOT NULL,
                        name VARCHAR(100) NOT NULL,
                        price DOUBLE PRECISION NOT NULL,
                        type VARCHAR(10) CHECK (type IN ('físico', 'digital')) NOT NULL,
                        shipping_cost DOUBLE PRECISION,
                        download_link VARCHAR(255),
                        CONSTRAINT chk_shipping_cost_or_download_link CHECK (
                            (type = 'físico' AND shipping_cost IS NOT NULL AND download_link IS NULL) OR
                            (type = 'digital' AND download_link IS NOT NULL AND shipping_cost IS NULL)
                        )
                    );
                """;

        jdbcTemplate.execute(createTableSql);
    }
}
