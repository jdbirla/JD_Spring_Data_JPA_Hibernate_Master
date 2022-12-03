package com.jd.spring.data.jpa.repository;

import com.jd.spring.data.jpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jd birla on 02-12-2022 at 12:38
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
