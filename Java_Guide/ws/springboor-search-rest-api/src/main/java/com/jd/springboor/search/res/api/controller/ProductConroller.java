package com.jd.springboor.search.res.api.controller;

import com.jd.springboor.search.res.api.Entity.Product;
import com.jd.springboor.search.res.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jd birla on 02-12-2022 at 17:52
 */
@RestController
@RequestMapping("/api/v1/products")
public class ProductConroller {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query)
    {
        return ResponseEntity.ok(productService.searchProducts(query));
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product)
    {
        return productService.createProduct(product);
    }
}
