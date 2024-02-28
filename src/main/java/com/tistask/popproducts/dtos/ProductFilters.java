package com.tistask.popproducts.dtos;

public class ProductFilters {
    private String code;
    private String name;
    
    public ProductFilters(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductFilters [code=" + code + ", name=" + name + "]";
    }
}
