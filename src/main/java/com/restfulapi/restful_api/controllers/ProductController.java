package com.restfulapi.restful_api.controllers;

import com.restfulapi.restful_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // Endpoint to get all products
    @GetMapping
    public ResponseEntity<List<String>> getAllProducts() {
        List<String> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}
