package com.company.service;

import com.company.model.Student;

import java.util.List;

public interface StudentService {

    public Student saveStudent(Student student);

    public List<Student> getAllStudent();

    public Student getStudentById(Integer id);

    public String deleteStudent(Integer id);

    public Student editStudent(Student student, Integer id);
}
