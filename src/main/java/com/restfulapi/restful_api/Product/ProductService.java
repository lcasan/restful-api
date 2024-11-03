package com.restfulapi.restful_api.Product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    // Inject an instance of JdbcTemplate
    @Autowired
    JdbcTemplate jdbc;

    //  Create a new product in the database
    public boolean createProduct(Product product) {
        String sql = String.format(
            """
                INSERT INTO products (name, price, type, shipping_cost, download_link) 
                VALUES ('%s', %.2f, '%s', %s, %s);
            """,
            product.getName(),
            product.getPrice(),
            product.getType(),
            product.getShippingCost() != null ? String.format("%.2f", product.getShippingCost()) : "NULL",
            product.getDownloadLink() != null ? "'" + product.getDownloadLink() + "'" : "NULL"
        );

        try{
            jdbc.execute(sql);
            return true; // Return true if the insertion was successful
        } catch (Exception e) {
            e.printStackTrace();
        }

    return false; // Return false if the insertion failed
    }

    // Method to get all products from the database
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
    
        try {
            products = jdbc.query(sql, (rs, _) -> new Product(
                rs.getInt("code"),
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getString("type"),
                rs.getDouble("shipping_cost"),
                rs.getString("download_link")
            ));
            
            products.forEach(product -> System.out.println(product));
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return products; // Return the list of products
    }

    // Method to delete a product in the database
    public boolean deleteProduct(int productCode) {
        String sql = String.format(
            """
                DELETE FROM products WHERE code=%d   
            """, 
            productCode
        );

        try{
            jdbc.execute(sql);
            return true; // Returns true if the deletion was successful.
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Method to search products by name
    public List<Product> searchProductsByName(String productName) {
        List<Product> products = new ArrayList<>();
        String sql = String.format(
            """
                SELECT * FROM products WHERE name='%s'        
            """,
            productName
        );
        System.out.println(productName);
        try{
            products = jdbc.query(sql, (rs, _) -> new Product(
                rs.getInt("code"),
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getString("type"),
                rs.getDouble("shipping_cost"),
                rs.getString("download_link")
            ));
            
            products.forEach(product -> System.out.println(product));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
}
