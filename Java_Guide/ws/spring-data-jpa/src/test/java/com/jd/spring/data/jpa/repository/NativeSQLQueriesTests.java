package com.jd.spring.data.jpa.repository;

import com.jd.spring.data.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by jd birla on 01-12-2022 at 07:07
 */
@SpringBootTest
public class NativeSQLQueriesTests {
    Logger logger = LoggerFactory.getLogger(ProductRepositoryTest.class);
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameorDescriptionSQLIndexParam()
    {
        Product product = productRepository.findByNameorDescriptionSQLIndexParam("Prod2", "sadsad");
        logger.info(product.toString());
    }

    @Test
    void findByNameorDescriptionSQLNamedParam()
    {
        Product product = productRepository.findByNameorDescriptionSQLNamedParam("Prod2", "sadsad");
        logger.info(product.toString());
    }



}
