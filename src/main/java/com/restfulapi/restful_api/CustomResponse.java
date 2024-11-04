package com.restfulapi.restful_api;
import java.util.List;

public class CustomResponse<T> {
    private List<T> data;
    private String message;

    public CustomResponse(List<T> data, String message) {
        this.data = data;
        this.message = message;
    }

    // Getters y Setters
    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
