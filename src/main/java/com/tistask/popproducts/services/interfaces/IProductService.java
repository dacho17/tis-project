package com.tistask.popproducts.services.interfaces;

import java.util.List;

import com.tistask.popproducts.dtos.ProductDTO;
import com.tistask.popproducts.dtos.ProductFilters;
import com.tistask.popproducts.dtos.RatedProduct;
import com.tistask.popproducts.dtos.RegisterProductForm;

public interface IProductService {
    ProductDTO storeProduct(RegisterProductForm regForm);
    List<ProductDTO> getProducts(ProductFilters filters);
    List<RatedProduct> getMostPopularProducts();
}
