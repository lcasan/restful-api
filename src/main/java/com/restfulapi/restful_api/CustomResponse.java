package com.restfulapi.restful_api;

public class CustomResponse<T> {
    private T data;
    private String message;

    public CustomResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }

    // Getters y Setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
