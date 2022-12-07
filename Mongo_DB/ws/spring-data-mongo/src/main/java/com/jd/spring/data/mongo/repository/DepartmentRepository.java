package com.jd.spring.data.mongo.repository;

import com.jd.spring.data.mongo.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {

}
