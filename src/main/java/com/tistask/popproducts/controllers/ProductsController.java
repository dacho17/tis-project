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

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/products", produces = { "application/json" })
public class ProductsController {
    private static final Logger logger = LoggerFactory.getLogger(ProductsController.class);

    @Autowired
    IProductService productService;

    @ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/new_product")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201", description = "Product created", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseObject.class)),}),
		@ApiResponse(responseCode = "400", description = "Data received is of incorrect format.", content = @Content),
		@ApiResponse(responseCode = "500", description = "Database error has occurred.", content = @Content) })
    public ResponseObject<ProductDTO> registerProduct(@RequestBody RegisterProductForm regForm) throws Exception {
		logger.info("POST /products/new_product endpoint accessed.");

		if (!regForm.isFormValid()) {
			logger.error(String.format("The data received in the registerProduct is of incorrect format. Form received=[%s]", regForm.toString()));
			throw new ApiBadRequestException();
		}

		ProductDTO prodcutDto = productService.storeProduct(regForm);

		return new ResponseObject<ProductDTO>(prodcutDto, "Product created.", false);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping()
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Products fetched", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseObject.class)),}),
		@ApiResponse(responseCode = "500", description = "Database error has occurred.", content = @Content) })
	public ResponseObject<List<ProductDTO>> fetchProducts(@RequestBody(required = false) ProductFilters filters) throws Exception {
		logger.info("POST /products endpoint accessed");

		List<ProductDTO> productDtos = productService.getProducts(filters);

		return new ResponseObject<List<ProductDTO>>(productDtos, "Products fetched.", false);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/most_popular")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Most popular products fetched", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseObject.class)),}),
		@ApiResponse(responseCode = "500", description = "Database error has occurred.", content = @Content) })
	public ResponseObject<List<RatedProduct>> fetchMostPopularObjects() throws Exception {
		logger.info("GET /products/most_popular endpoint accessed");

		List<RatedProduct> popProducts = productService.getMostPopularProducts();

		return new ResponseObject<List<RatedProduct>>(popProducts, "Most popular products fetched.", false);
	}
}
