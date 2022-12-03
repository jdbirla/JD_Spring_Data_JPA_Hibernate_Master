package com.jd.spring.data.jpa.repository;

import com.jd.spring.data.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jd birla on 02-12-2022 at 12:37
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
