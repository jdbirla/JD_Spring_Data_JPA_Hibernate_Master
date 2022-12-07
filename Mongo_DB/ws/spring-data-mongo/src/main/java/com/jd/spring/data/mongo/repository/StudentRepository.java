package com.jd.spring.data.mongo.repository;

import java.util.List;

import com.jd.spring.data.mongo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByName(String name);

    Student findByEmailAndName (String email, String name);

    Student findByNameOrEmail (String name, String email);

    List<Student> findByDepartmentDepartmentName(String deptname);

    List<Student> findBySubjectsSubjectName (String subName);

    List<Student> findByEmailIsLike (String email);

    List<Student> findByNameStartsWith (String name);

}
