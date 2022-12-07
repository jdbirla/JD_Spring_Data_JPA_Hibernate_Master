package com.jd.spring.data.mongo.repository;

import com.jd.spring.data.mongo.entity.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SubjectRepository extends MongoRepository<Subject, String> {

}
