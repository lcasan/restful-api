package com.restfulapi.restful_api.Product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Enpoint to create product
    @PutMapping("/new")
    public boolean createProduct(@RequestBody Product product) {

        return productService.createProduct(product);
    }

    // Endpoint to get all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        return products;
    }
}
