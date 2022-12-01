package com.jd.spring.data.jpa.repository;

import com.jd.spring.data.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by jd birla on 30-11-2022 at 06:43
 */
@SpringBootTest
class ProductRepositoryTest {

    Logger logger = LoggerFactory.getLogger(ProductRepositoryTest.class);
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void SaveProduct() {
        Product product = new Product();
        product.setName("Prod1");
        product.setImageUrl("somt.png");
        product.setPrice(new BigDecimal(100));
        product.setSku("100asda");
        product.setActive(true);
        //Saverpoiduct
        Product savedProduct = productRepository.save(product);

        logger.info(savedProduct.getId().toString());
        logger.info(savedProduct.toString());

    }

    @Test
    public void saveMultipleProducts() {
        //Fetch the product
        Product product2 = new Product();
        product2.setName("Prod2");
        product2.setImageUrl("somt.png");
        product2.setPrice(new BigDecimal(100));
        product2.setSku("1001asda");
        product2.setActive(true);
        product2.setDescription("prod2 decs2");

        Product product3 = new Product();
        product3.setName("Prod3");
        product3.setImageUrl("somt.png");
        product3.setPrice(new BigDecimal(100));
        product3.setSku("1002asda");
        product3.setActive(true);
        product3.setDescription("prod3 decs2");

        List<Product> products = productRepository.saveAll(List.of(product2, product3));
        logger.info(products.toString());

    }


    @Test
    public void findProductById() {
        //Fetch the product
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        logger.info(product.toString());

    }

    @Test
    public void findAllProducts() {
        //Fetch the product

        List<Product> allProducts = productRepository.findAll();

        allProducts.forEach(System.out::println);

    }


    @Test
    public void updateProduct() {
        //Fetch the product
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        product.setName("Prod1 updated");
        product.setDescription("new desc");
        //Saverpoiduct
        Product savedProduct = productRepository.save(product);

        logger.info(savedProduct.getId().toString());
        logger.info(savedProduct.toString());

    }


    @Test
    public void deleteProductById() {
        //Fetch the product
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    public void deleteProduct() {
        //Fetch the product
        Long id = 6L;
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    @Test
    public void deleteAllProduct() {

        productRepository.deleteAll();
    }

    @Test
    public void countProducts() {

        Long countProducts = productRepository.count();
        logger.info(countProducts.toString());
    }


    @Test
    public void existsById() {

        Long id = 8L;
        boolean isProductExists = productRepository.existsById(id);
        System.out.println(isProductExists);
    }




}