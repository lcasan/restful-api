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
    @PostMapping("/new")
    public boolean createProduct(@RequestBody Product product) {

        return productService.createProduct(product);
    }

    // Endpoint to get all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        return products;
    }

    // Endpoint to delete a product by code
    @DeleteMapping("/delete/{code}")
    public boolean deleteProduct(@PathVariable int code) {
        return productService.deleteProduct(code);
    }

}
