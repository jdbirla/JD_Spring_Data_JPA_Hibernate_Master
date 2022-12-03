package com.jd.springboor.search.res.api.repository;

import com.jd.springboor.search.res.api.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by jd birla on 02-12-2022 at 17:39
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(" select p from Product p where " +
            " p.name LIKE CONCAT('%' , :query , '%') OR" +
            " p.description LIKE CONCAT('%' , :query , '%')")
    List<Product> searchProduct(@Param("query") String query);

    @Query(value = " select * from products p where " +
            " p.name LIKE CONCAT('%' , :query , '%') OR" +
            " p.description LIKE CONCAT('%' , :query , '%')" , nativeQuery = true)
    List<Product> searchProductsSQL(@Param("query") String query);
}
