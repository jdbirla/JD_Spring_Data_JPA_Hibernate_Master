package com.jd.spring.data.jpa.repository;

import com.jd.spring.data.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by jd birla on 29-11-2022 at 09:03
 */
public interface ProductRepository extends JpaRepository<Product , Long> {

    /**
     *
     * @param name prodcyt name
     * @returnProduct or null
     */
    public Product findByName(String name);
    public Optional<Product> findById(Long id);
    public List<Product> findByNameOrDescription(String name, String description);
    public List<Product> findByNameAndDescription(String name, String description);
    public Product findDistinctByName(String name);

    public List<Product> findByPriceGreaterThan(BigDecimal price);
    public List<Product> findByPriceLessThan(BigDecimal price);

    public List<Product> findByNameContainingIgnoreCase(String name);
    public List<Product> findByNameLikeIgnoreCase(String name);
    public List<Product> findByPriceBetween(BigDecimal startPrice ,  BigDecimal endProce);
    public List<Product> findByDateCreatedBetween(LocalDateTime startDate , LocalDateTime endDate);
    public List<Product> findByNameIn(List<String> names);
    public List<Product> findFirst5ByName(String name);
    public List<Product> findTop5ByOrderByDateCreatedDesc();

    //JPQL Query using index params
    @Query("select p from Product p where p.name  =?1 or p.description=?2")
    public Product findByNameorDescriptionJPQLIndexParam(String name, String description);

    //JPQL Query using named params
    @Query("select p from Product p where p.name  =:name or p.description=:desc")
    public Product findByNameorDescriptionJPQLNamedParam(@Param("name") String name, @Param("desc") String description);

    //Native SQl Query using index params
    @Query(value = "select * from products p where p.name  =?1 or p.description=?2" , nativeQuery = true)
    public Product findByNameorDescriptionSQLIndexParam(String name, String description);


    //Native SQL Query using named params

    @Query(value = "select * from products p where p.name  =:name or p.description=:desc" , nativeQuery = true)
    public Product findByNameorDescriptionSQLNamedParam(@Param("name") String name, @Param("desc") String description);

    public Product findByPrice(@Param("price") BigDecimal price);

    public List<Product> findAllProductsOrderByNameDesc();

    //@Query(nativeQuery = true)
    public Product findBySku (String sku);

//    @Query(nativeQuery = true)
    public List<Product> findAllProductsOrderByNameAsc();



}
