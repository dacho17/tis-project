package com.tistask.popproducts.dtos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RatedProduct {
    private final static int NUMBER_OF_DECIMALS = 1;
    
    private String name;
    private double averageRating;
    
    public RatedProduct(String name, double averageRating) {
        this.name = name;

        BigDecimal bd = new BigDecimal(Double.toString(averageRating));
        bd = bd.setScale(NUMBER_OF_DECIMALS, RoundingMode.HALF_UP);
        this.averageRating = bd.doubleValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    @Override
    public String toString() {
        return "RatedProduct [name=" + name + ", averageRating=" + averageRating + "]";
    }
}
