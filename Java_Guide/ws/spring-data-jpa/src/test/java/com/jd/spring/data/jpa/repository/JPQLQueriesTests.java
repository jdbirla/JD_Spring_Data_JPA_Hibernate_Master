package com.jd.spring.data.jpa.repository;

import com.jd.spring.data.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by jd birla on 01-12-2022 at 06:55
 */
@SpringBootTest
public class JPQLQueriesTests {

    Logger logger = LoggerFactory.getLogger(ProductRepositoryTest.class);
    @Autowired
    private ProductRepository productRepository;


    @Test
    void findByNameorDescriptionJPQLIndexParam()
    {
        Product product = productRepository.findByNameorDescriptionJPQLIndexParam("Prod2", "sadsad");
        logger.info(product.toString());
    }

    @Test
    void findByNameorDescriptionJPQLNamedParam()
    {
        Product product = productRepository.findByNameorDescriptionJPQLNamedParam("Prod2", "sadsad");
        logger.info(product.toString());
    }



}
