package com.restfulapi.restful_api.Product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.restfulapi.restful_api.CustomResponse;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Enpoint to create product
    @PostMapping("/new")
    public ResponseEntity<CustomResponse<Product>> createProduct(@RequestBody Product product) {
        // Data query
        List<Product> data = productService.createProduct(product);
        
        // Response
        String message = (data.isEmpty())? "Operation failed" : "Operation successfully";
        CustomResponse<Product> response = new CustomResponse<>(data, message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Endpoint to get all products
    @GetMapping("/products")
    public ResponseEntity<CustomResponse<Product>> getAllProducts() {
        // Data Query
        List<Product> data = productService.getAllProducts();
        
        // Response
        String message = (data.isEmpty())? "Operation failed" : "Operation successfully";
        CustomResponse<Product> response = new CustomResponse<>(data, message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Endpoint to delete a product by code
    @DeleteMapping("/delete")
    public ResponseEntity<CustomResponse<Product>> deleteProduct(@RequestParam Integer code) {
        // Data query 
        List<Product> data = productService.deleteProduct(code);

        // Response
        String message = (data.isEmpty())? "Operation failed" : "Operation successfully";
        CustomResponse<Product> response = new CustomResponse<>(data, message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Endpoint to search products by name
    @GetMapping("/search")
    public ResponseEntity<CustomResponse<Product>> getProductByName(@RequestParam String name) {
        // Data query
        List<Product> data = productService.searchProductsByName(name);

        // Response
        CustomResponse<Product> response = new CustomResponse<>(data, "Operation successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Endpoint to update a product by code
    @PutMapping("/update/{code}")
    public ResponseEntity<CustomResponse<Product>> updateProduct(@PathVariable Integer code, @RequestBody Product product) {
        // Data query
        List<Product> data = productService.updateProduct(code, product);

        // Response
        String message = (data.isEmpty())? "Operation failed" : "Operation successfully";
        CustomResponse<Product> response = new CustomResponse<>(data, message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
