package com.jd.spring.data.mongo.service;

import java.util.List;

import com.jd.spring.data.mongo.entity.Student;
import com.jd.spring.data.mongo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student createStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
    }

    public Student getStudentbyId(String id) {
       return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public String deleteStudentbyId(String id) {
         studentRepository.deleteById(id);
       return  "delete stundetn sucessfully";
    }
}
