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
 * Created by jd birla on 01-12-2022 at 07:21
 */
@SpringBootTest
class NamedQueriedTests {

    Logger logger = LoggerFactory.getLogger(ProductRepositoryTest.class);
    @Autowired
    private ProductRepository productRepository;

    @Test
    void namedJPQLQuey(){
        Product product = productRepository.findByPrice(new BigDecimal(100.00));
        logger.info(product.toString());
    }
    @Test
    void findAllProductsOrderByNameDesc(){
        List<Product> allProductsOrderByNameDesc = productRepository.findAllProductsOrderByNameDesc();

        allProductsOrderByNameDesc.forEach(System.out::println);
    }

    @Test
    void findBySku(){
        Product bySku = productRepository.findBySku("1001asda");
        logger.info(bySku.toString());
    }

    @Test
    void findAllProductsOrderByNameAsc(){
        List<Product> findAllProductsOrderByNameAsc = productRepository.findAllProductsOrderByNameAsc();

        findAllProductsOrderByNameAsc.forEach(System.out::println);
    }

}