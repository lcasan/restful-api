package com.restfulapi.restful_api.Product;

import jakarta.validation.constraints.*;

public class Product {
    private Integer code;

    @NotBlank(message = "The name is required")
    private String name;

    @Min(value = 0, message = "Price must be a non-negative integer.")
    private Double price;

    @Pattern(regexp = "^(físico|digital)$", message = "Type must be either 'físico' or 'digital'")
    private String type;

    @DecimalMin(value = "0.0", message = "Shipping cost must be a non-negative value for physical products.")
    private Double shippingCost;

    @Pattern(regexp = "\\b(https?://[^\\s/$.?#].[^\\s]*|www\\.[^\\s/$.?#].[^\\s]*)\\b", message = "Invalid download link format")
    private String downloadLink;

    // Constructors
    Product(){}
    
    Product(Integer code, String name, Double price, String type, Double shippingCost, String downloadLink) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.type = type;
        this.shippingCost = shippingCost;
        this.downloadLink = downloadLink;
    }

    // Getter and setter functions
    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getType() {
        return this.type;
    }

    public Double getShippingCost() {
        return this.shippingCost;
    }

    public String getDownloadLink() {
        return this.downloadLink;
    }
}