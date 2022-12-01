package com.jd.spring.data.jpa.repository;

import com.jd.spring.data.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

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








}
