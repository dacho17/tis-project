package com.tistask.popproducts.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tistask.popproducts.dtos.ProductDTO;
import com.tistask.popproducts.dtos.ProductFilters;
import com.tistask.popproducts.dtos.RatedProduct;
import com.tistask.popproducts.dtos.RegisterProductForm;
import com.tistask.popproducts.dtos.ResponseObject;
import com.tistask.popproducts.exceptions.ApiBadRequestException;
import com.tistask.popproducts.services.interfaces.IProductService;

@RestController
@RequestMapping(value = "/products", produces = { "application/json" })
public class ProductsController {
    private static final Logger logger = LoggerFactory.getLogger(ProductsController.class);

    @Autowired
    IProductService productService;

    @ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/new_product")
    public ResponseObject<ProductDTO> registerProduct(@RequestBody RegisterProductForm regForm) throws Exception {
		logger.info("POST /products/new_product endpoint accessed.");

		if (!regForm.isFormValid()) {
			logger.error(String.format("The data received in the registerProduct is of incorrect format. Form received=[%s]", regForm.toString()));
			throw new ApiBadRequestException();
		}

		ProductDTO prodcutDto = productService.storeProduct(regForm);

		return new ResponseObject<ProductDTO>(prodcutDto, null, false);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping()
	public ResponseObject<List<ProductDTO>> fetchProducts(@RequestBody ProductFilters filters) throws Exception {
		logger.info("POST /products endpoint accessed");

		List<ProductDTO> productDtos = productService.getProducts(filters);

		return new ResponseObject<List<ProductDTO>>(productDtos, null, false);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/most_popular")
	public ResponseObject<List<RatedProduct>> fetchMostPopularObjects() throws Exception {
		logger.info("GET /products/most_popular endpoint accessed");

		List<RatedProduct> popProducts = productService.getMostPopularProducts();

		return new ResponseObject<List<RatedProduct>>(popProducts, null, false);
	}
}
