package com.tistask.popproducts.dtos;

public class ProductDTO {
    private String code;
    private String name;
    private double priceEUR;
    private double priceUSD;
    private String description;

    public ProductDTO(String code, String name, double priceEUR, double priceUSD, String description) {
        this.code = code;
        this.name = name;
        this.priceEUR = priceEUR;
        this.priceUSD = priceUSD;
        this.description = description;
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

    public double getPriceEUR() {
        return priceEUR;
    }

    public void setPriceEUR(double priceEUR) {
        this.priceEUR = priceEUR;
    }

    public double getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(double priceUSD) {
        this.priceUSD = priceUSD;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductDTO [code=" + code + ", name=" + name + ", priceEUR=" + priceEUR + ", priceUSD=" + priceUSD
                + ", description=" + description + "]";
    }
}
