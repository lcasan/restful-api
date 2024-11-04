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
    @DeleteMapping("/delete")
    public boolean deleteProduct(@RequestParam Integer code) {
        return productService.deleteProduct(code);
    }

    // Endpoint to search products by name
    @GetMapping("/search")
    public List<Product> getProductByName(@RequestParam String name) {
        List<Product> products = productService.searchProductsByName(name);

        return products;
    }

    // Endpoint to update a product by code
    @PutMapping("/update/{code}")
    public boolean updateProduct(@PathVariable Integer code, @RequestBody Product product) {
        return productService.updateProduct(code, product);
    }
}
