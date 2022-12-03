package com.jd.spring.data.jpa.repository;

import com.jd.spring.data.jpa.entity.ProductCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
