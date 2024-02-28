package com.tistask.popproducts.repositories;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tistask.popproducts.dtos.ProductFilters;
import com.tistask.popproducts.dtos.RatedProduct;
import com.tistask.popproducts.entities.Product;
import com.tistask.popproducts.exceptions.DbException;
import com.tistask.popproducts.repositories.interfaces.IProductRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class ProductRepository implements IProductRepository{
    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @Autowired
    private EntityManager entityManager;
    
    public Product create(Product product) {
        logger.info(String.format("New Product is about to be created."));

        try {
            entityManager.persist(product);

            logger.info(String.format("Successfully created new Product with id=%d", product.getId()));
            return product;
        } catch (Exception exc) {
            logger.error(String.format("An error occured while attempting to create a new Product. Error - [%s]", exc.getMessage()));
            throw new DbException("Product could not be created.");
        }
    }

    public List<Product> retrieveProducts(ProductFilters filters) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Product> query = cb.createQuery(Product.class);
	    Root<Product> root = query.from(Product.class);
	    query = query.select(root)
            .where(cb.and(
                cb.like(
                    cb.lower(root.get("code")),
                    cb.lower(cb.literal("%" + filters.getCode() + "%"))
                ),
                cb.like(
                    cb.lower(root.get("name")),
                    cb.lower(cb.literal("%" + filters.getName() + "%"))
                )
            ));

		try {
            List<Product> products = entityManager.createQuery(query).getResultList();
            logger.info(String.format("%d Products have been found with filter - [%s]", products.size(), filters.toString()));
			
            return products;
		} catch (NoResultException exc) {
			logger.info(String.format("No Products have been found with filter - [%s]", filters.toString()));
			return new ArrayList<Product>();
		} catch (Exception exc) {
            logger.error(String.format("An error occurred while attempting to retrieve products with filter - [%s]. Error - [%s]",
                filters.toString(), exc.getMessage()));
            throw new DbException("Products could not be fetched.");
        }
    }

    public List<RatedProduct> retrieveMostPopularProducts() {
        String rawQuery =
            "select product.name, avg(review.rating) as average_rating"
            + " from product inner join review"
            + " on product.id = review.product_id"
            + " group by product.code"
            + " order by average_rating desc"
            + " limit 3;";

        try {
            List<RatedProduct> popProducts = entityManager.createNativeQuery(rawQuery, RatedProduct.class).getResultList();
            logger.info(String.format("%d most popular products have been found.", popProducts.size()));
    
            return popProducts;
        } catch(NoResultException exc) {
            logger.info(String.format("No popular proudcts have been found."));
			return new ArrayList<RatedProduct>();
        } catch (Exception exc) {
            logger.error(String.format("An error occurred while attempting to retrieve popular products. Error - [%s]", exc.getMessage()));
            throw new DbException("Most popular products could not be fetched.");
        }
    }

}
