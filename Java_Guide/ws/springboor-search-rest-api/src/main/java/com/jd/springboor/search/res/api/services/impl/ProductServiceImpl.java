package com.jd.springboor.search.res.api.services.impl;

import com.jd.springboor.search.res.api.Entity.Product;
import com.jd.springboor.search.res.api.repository.ProductRepository;
import com.jd.springboor.search.res.api.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jd birla on 02-12-2022 at 17:50
 */
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> searchProducts(String query) {
        List<Product> products = productRepository.searchProduct(query);
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
