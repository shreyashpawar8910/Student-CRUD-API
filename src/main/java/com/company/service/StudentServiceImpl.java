package com.company.service;

import com.company.model.Student;
import com.company.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public String deleteStudent(Integer id) {
        Student student = studentRepository.findById(id).get();

        if (student!=null){
            studentRepository.delete(student);
            return "Data Delete Successful...";
        }

        return "Something went wrong..!!";
    }

    @Override
    public Student editStudent(Student student, Integer id) {

        Student oldStudent = studentRepository.findById(id).get();

        oldStudent.setStudentFirstName(student.getStudentFirstName());
        oldStudent.setStudentMiddleName(student.getStudentMiddleName());
        oldStudent.setStudentLastName(student.getStudentLastName());
        oldStudent.setRollNo(student.getRollNo());
        oldStudent.setCity(student.getCity());
        oldStudent.setAddress(student.getAddress());
        oldStudent.setContactNumber(student.getContactNumber());

        return studentRepository.save(oldStudent);
    }

}
