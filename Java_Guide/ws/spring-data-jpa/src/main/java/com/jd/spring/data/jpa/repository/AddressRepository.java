package com.jd.spring.data.jpa.repository;

import com.jd.spring.data.jpa.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jd birla on 02-12-2022 at 08:02
 */
public interface AddressRepository extends JpaRepository<Address, Long> {

}
