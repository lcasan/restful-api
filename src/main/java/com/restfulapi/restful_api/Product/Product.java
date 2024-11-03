package com.restfulapi.restful_api.Product;
// import javax.validation.constraints.*;


public class Product {    
    // @NotBlank(message = "El nombre es obligatorio")
    private Integer code;
    private String name;
    private Double price;
    private String type;
    private Double shippingCost;
    private String downloadLink;

    // Constructor
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