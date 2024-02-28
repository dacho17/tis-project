package com.tistask.popproducts.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tistask.popproducts.agents.interfaces.IHnbAgent;
import com.tistask.popproducts.dtos.HnbCurrencyResponse;
import com.tistask.popproducts.dtos.ProductDTO;
import com.tistask.popproducts.dtos.ProductFilters;
import com.tistask.popproducts.dtos.RatedProduct;
import com.tistask.popproducts.dtos.RegisterProductForm;
import com.tistask.popproducts.entities.Product;
import com.tistask.popproducts.helpers.ProductHelper;
import com.tistask.popproducts.mappers.ProductMapper;
import com.tistask.popproducts.repositories.interfaces.IProductRepository;
import com.tistask.popproducts.services.interfaces.IProductService;

import jakarta.transaction.Transactional;

@Service
public class ProductService implements IProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IHnbAgent hnbAgent;

    @Transactional
    public ProductDTO storeProduct(RegisterProductForm regForm) {
        Product newProduct = ProductMapper.regFormToMAP(regForm);

        HnbCurrencyResponse eurUsdExchangeRates = hnbAgent.fetchExchangeRateEURUSD();
        boolean exchangeRateFound = eurUsdExchangeRates != null && eurUsdExchangeRates.getFormattedProdajniTecaj() != null;
        if (exchangeRateFound) {
            ProductHelper.setProductUSDPrice(newProduct, eurUsdExchangeRates.getFormattedProdajniTecaj(), regForm);
        } else {
            logger.warn("EUR-USD exchange rate was not found in currency response. USD price is set to 0.");
        }

        newProduct = productRepository.create(newProduct);

        ProductDTO newProductDto = ProductMapper.MAPtoDTO(newProduct);
        return newProductDto;
    }

    public List<ProductDTO> getProducts(ProductFilters filters) {
        List<Product> filteredProducts = productRepository.retrieveProducts(filters);

        List<ProductDTO> filteredProductDtos = filteredProducts.stream().map(product -> ProductMapper.MAPtoDTO(product)).toList();
        return filteredProductDtos;
    }

    public List<RatedProduct> getMostPopularProducts() {
        List<RatedProduct> popProducts = productRepository.retrieveMostPopularProducts();

        return popProducts;
    }
}
