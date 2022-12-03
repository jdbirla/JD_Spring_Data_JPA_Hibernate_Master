package com.jd.spring.data.jpa.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by jd birla on 02-12-2022 at 07:54
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "addresses"
)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    private Order order;
}
