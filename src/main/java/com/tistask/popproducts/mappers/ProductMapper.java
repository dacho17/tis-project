package com.tistask.popproducts.mappers;

import java.sql.Timestamp;

import com.tistask.popproducts.dtos.ProductDTO;
import com.tistask.popproducts.dtos.RegisterProductForm;
import com.tistask.popproducts.entities.Product;

public class ProductMapper {
    public static Product regFormToMAP(RegisterProductForm regForm) {
        Product newProduct = new Product();
        newProduct.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        newProduct.setCode(regForm.getCode());
        newProduct.setName(regForm.getName());
        newProduct.setPriceEUR(regForm.getPriceEUR());
        newProduct.setDescription(regForm.getDescription());

        return newProduct;
    }

    public static ProductDTO MAPtoDTO(Product productMAP) {
        ProductDTO productDto = new ProductDTO(
            productMAP.getCode(),
            productMAP.getName(),
            productMAP.getPriceEUR(),
            productMAP.getPriceUSD(),
            productMAP.getDescription()
        );

        return productDto;
    }
}
