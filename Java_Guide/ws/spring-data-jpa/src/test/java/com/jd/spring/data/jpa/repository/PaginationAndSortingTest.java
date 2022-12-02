package com.jd.spring.data.jpa.repository;

import com.jd.spring.data.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by jd birla on 01-12-2022 at 08:28
 */
@SpringBootTest
public class PaginationAndSortingTest {


    Logger logger = LoggerFactory.getLogger(ProductRepositoryTest.class);
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findAllWithPagination() {
        int pagno = 1;
        int pageSize = 15;

        Pageable pageable = PageRequest.of(pagno, pageSize);

        Page<Product> productsWithPagination = productRepository.findAll(pageable);

        List<Product> productList = productsWithPagination.getContent();

        productList.forEach(System.out::println);
        System.out.println("pageable.getTotalPages() :" + productsWithPagination.getTotalPages());
        System.out.println("pageable.getTotalElements() :" + productsWithPagination.getTotalElements());
        System.out.println("pageable.getNumberOfElements() :" + productsWithPagination.getNumberOfElements());
        System.out.println("pageable.getSize() :" + productsWithPagination.getSize());
        System.out.println("pageable.isFirst() :" + productsWithPagination.isFirst());
        System.out.println("pageable.isLast() :" + productsWithPagination.isLast());


    }

    @Test
    void findProductBySort() {
        String sortBy = "price";
        String sortDirection = "Asc";

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        List<Product> productSortBy = productRepository.findAll(sort);
        productSortBy.forEach(System.out::println);
    }

    @Test
    void findProductBySortingByMuiltpleFields() {
        String sortByName = "name";
        String sortByPirce = "price";

        String sortDirectionForName = "Asc";
        String sortDirectionForPrice = "Desc";


        Sort sortByNameAsc = sortDirectionForName.equalsIgnoreCase(Sort.Direction.DESC.name()) ? Sort.by(sortByName).descending()
                : Sort.by(sortByName).ascending();
        Sort sortByPriceDesc = sortDirectionForPrice.equalsIgnoreCase(Sort.Direction.DESC.name()) ? Sort.by(sortByPirce).descending()
                : Sort.by(sortByPirce).ascending();
        Sort groupBySort = sortByNameAsc.and(sortByPriceDesc);
        List<Product> productSortBy = productRepository.findAll(groupBySort);
        productSortBy.forEach(System.out::println);
    }

    @Test
    void findProductBySortingByMuiltpleFieldsWithPagination() {
        String sortByName = "name";
        String sortByPirce = "price";

        String sortDirectionForName = "Asc";
        String sortDirectionForPrice = "Desc";


        Sort sortByNameAsc = sortDirectionForName.equalsIgnoreCase(Sort.Direction.DESC.name()) ? Sort.by(sortByName).descending()
                : Sort.by(sortByName).ascending();
        Sort sortByPriceDesc = sortDirectionForPrice.equalsIgnoreCase(Sort.Direction.DESC.name()) ? Sort.by(sortByPirce).descending()
                : Sort.by(sortByPirce).ascending();
        Sort groupBySort = sortByNameAsc.and(sortByPriceDesc);

        int pagno = 0;
        int pageSize = 4;

        Pageable pageable = PageRequest.of(pagno, pageSize, groupBySort);

        Page<Product> productsWithPagination = productRepository.findAll(pageable);

        List<Product> productList = productsWithPagination.getContent();

        productList.forEach(System.out::println);
        System.out.println("pageable.getTotalPages() :" + productsWithPagination.getTotalPages());
        System.out.println("pageable.getTotalElements() :" + productsWithPagination.getTotalElements());
        System.out.println("pageable.getNumberOfElements() :" + productsWithPagination.getNumberOfElements());
        System.out.println("pageable.getSize() :" + productsWithPagination.getSize());
        System.out.println("pageable.isFirst() :" + productsWithPagination.isFirst());
        System.out.println("pageable.isLast() :" + productsWithPagination.isLast());

    }


}
