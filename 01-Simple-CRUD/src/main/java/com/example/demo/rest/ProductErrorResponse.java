package com.example.demo.rest;

public class ProductErrorResponse {
    private  int status;
    private String message;
    private Long time;
    public ProductErrorResponse(){}

    public ProductErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.time = System.currentTimeMillis();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTime() {
        return time;
    }

    public void setTime() {
        this.time = System.currentTimeMillis();
    }
}
