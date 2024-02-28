package com.tistask.popproducts.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tistask.popproducts.dtos.RegisterProductForm;
import com.tistask.popproducts.entities.Product;
import com.tistask.popproducts.utils.MathOperations;

public class ProductHelper {
    private static final Logger logger = LoggerFactory.getLogger(ProductHelper.class);

    public static void setProductUSDPrice(Product newProduct, Double eurUsdExchangeRate, RegisterProductForm regForm) {
        double priceInUSD = MathOperations.multiplyAndRound(regForm.getPriceEUR(), eurUsdExchangeRate);
        newProduct.setPriceUSD(priceInUSD);
    }
}
