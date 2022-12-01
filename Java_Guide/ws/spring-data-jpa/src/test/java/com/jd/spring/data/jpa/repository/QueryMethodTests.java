package com.jd.spring.data.jpa.repository;

import com.jd.spring.data.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by jd birla on 30-11-2022 at 07:51
 */
@SpringBootTest
class QueryMethodTests {

    Logger logger = LoggerFactory.getLogger(ProductRepositoryTest.class);
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void findByNameProduct() {
        //Fetch the product
        Product product = productRepository.findByName("Prod2");
        logger.info(product.toString());
    }

    @Test
    public void findDistinctByNameProduct() {
        //Fetch the product
        Product product = productRepository.findDistinctByName("Prod2");
        logger.info(product.toString());
    }

    @Test
    public void findByIDProduct() {
        //Fetch the product
        Long id = 8L;
        Optional<Product> product = productRepository.findById(id);
        logger.info(product.get().toString());
    }

    @Test
    public void findByNameOrDescription() {
        //Fetch the product
       String productName = "Prod2";
        String productDescription = "prod2 decs2";


        List<Product> byNameOrDescription = productRepository.findByNameOrDescription(productName, productDescription);
        System.out.println(byNameOrDescription);
    }

    @Test
    public void findByNameAndDescription() {
        //Fetch the product
        String productName = "Prod2";
        String productDescription = "prod2 decs2";


        List<Product> byNameOrDescription = productRepository.findByNameAndDescription(productName, productDescription);
        System.out.println(byNameOrDescription);
    }

    @Test
    public void findByPriceGreaterThan() {
        //Fetch the product
        List<Product> byPriceGreaterThan = productRepository.findByPriceGreaterThan(new BigDecimal(99));
        logger.info(byPriceGreaterThan.toString());
    }

    @Test
    public void findByPriceLessThan() {
        //Fetch the product
        List<Product> byPriceGreaterThan = productRepository.findByPriceLessThan(new BigDecimal(101));
        logger.info(byPriceGreaterThan.toString());
    }


    @Test
    public void findByNameContainingIgnoreCase() {
        //Fetch the product
        List<Product> prod = productRepository.findByNameContainingIgnoreCase("Prod");
        prod.forEach(System.out::println);
    }

    @Test
    public void findByNameLikeIgnoreCase() {
        //Fetch the product
        List<Product> prod = productRepository.findByNameLikeIgnoreCase("Prod2");
        prod.forEach(System.out::println);

    }



    @Test
    public void findByPriceBetween() {
        //Fetch the product
        List<Product> prod = productRepository.findByPriceBetween(new BigDecimal(99) , new BigDecimal(101));
        prod.forEach(System.out::println);

    }
    @Test
    public void findByDateCreatedBetween() {
        //Fetch the product
        LocalDateTime startDate = LocalDateTime.of(2022, 12 ,01 ,07,15, 30);
        LocalDateTime endDate = LocalDateTime.of(2022, 12 ,01 ,07,23, 33);

        List<Product> prod = productRepository.findByDateCreatedBetween(startDate , endDate);
        prod.forEach(System.out::println);

    }


    @Test
    public void findByNameIn() {
        List<String> ProductNames = List.of("Prod2" , "Prod3");
        List<Product> prod = productRepository.findByNameIn(ProductNames);
        prod.forEach(System.out::println);

    }



    @Test
    public void findFirst5ByName() {
        List<Product> prod = productRepository.findFirst5ByName("Prod2");
        prod.forEach(System.out::println);

    }

    @Test
    public void findTop5ByOrderOrderByDateCreatedDesc() {
        List<Product> prod = productRepository.findTop5ByOrderByDateCreatedDesc();
        prod.forEach(System.out::println);

    }


}