package com.tistask.popproducts.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathOperations {
    public static double multiplyAndRound(double firstMultiplier, double secondMultiplier) {
        BigDecimal bd = new BigDecimal(Double.toString(firstMultiplier * secondMultiplier));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
