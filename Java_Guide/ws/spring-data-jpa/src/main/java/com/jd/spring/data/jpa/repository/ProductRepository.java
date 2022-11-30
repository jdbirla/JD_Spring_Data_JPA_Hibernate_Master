package com.jd.spring.data.jpa.repository;

import com.jd.spring.data.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jd birla on 29-11-2022 at 09:03
 */
public interface ProductRepository extends JpaRepository<Product , Long> {
}
