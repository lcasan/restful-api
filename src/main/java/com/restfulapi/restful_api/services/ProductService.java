package com.restfulapi.restful_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final DataSource dataSource;

    @Autowired
    public ProductService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getAllProducts() {
        List<String> products = new ArrayList<>();
        String sql = "SELECT name FROM products";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                products.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
}
