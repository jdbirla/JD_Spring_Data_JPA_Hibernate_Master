package com.jd.spring.data.jpa.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by jd birla on 29-11-2022 at 07:12
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "products" ,
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(name = "sku_uni_const" , columnNames = "stock_keeping_unit" )
        }
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "product_seq")
    @SequenceGenerator(name = "product_seq" , sequenceName = "product_seq_db" , allocationSize = 1)
    private Long id;
    @Column(name = "stock_keeping_unit" , nullable = false)
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}