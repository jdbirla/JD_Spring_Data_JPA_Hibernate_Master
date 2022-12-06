package com.jd.spring.data.mongo.repository;

import java.util.List;

import com.jd.spring.data.mongo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StudentRepository extends MongoRepository<Student, String> {


}
