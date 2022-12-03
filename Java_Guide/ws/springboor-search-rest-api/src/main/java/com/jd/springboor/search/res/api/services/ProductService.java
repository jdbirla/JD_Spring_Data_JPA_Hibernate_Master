package com.jd.springboor.search.res.api.services;

import com.jd.springboor.search.res.api.Entity.Product;

import java.util.List;

/**
 * Created by jd birla on 02-12-2022 at 17:49
 */
public interface ProductService {

    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}
