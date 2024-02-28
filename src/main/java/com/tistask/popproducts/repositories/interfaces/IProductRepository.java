package com.tistask.popproducts.repositories.interfaces;

import java.util.List;

import com.tistask.popproducts.dtos.ProductFilters;
import com.tistask.popproducts.dtos.RatedProduct;
import com.tistask.popproducts.entities.Product;
import com.tistask.popproducts.exceptions.DbException;

public interface IProductRepository {
    Product create(Product product) throws DbException;
    List<Product> retrieveProducts(ProductFilters filters) throws DbException;
    public List<RatedProduct> retrieveMostPopularProducts() throws DbException;
}
