package com.tistask.popproducts.dtos;

public class RegisterProductForm {
    private static final short CODE_LENGTH = 15;
    private static final short MIN_NAME_LENGTH = 1;

    private String code;
    private String name;
    private double priceEUR;
    private String description;
    
    public RegisterProductForm(String code, String name, double priceEUR, String description) {
        this.code = code;
        this.name = name;
        this.priceEUR = priceEUR;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFormValid() {
        if (code == null || code.length() != CODE_LENGTH) return false;
        if (name == null || name.length() < MIN_NAME_LENGTH) return false;
        if (priceEUR <= 0) return false;
        // description is not a necessary value

        return true;
    }

    @Override
    public String toString() {
        return "RegisterProductForm [code=" + code + ", name=" + name + ", priceEUR=" + priceEUR + ", description="
                + description + "]";
    }
}
