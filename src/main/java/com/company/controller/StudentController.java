package com.company.controller;

import com.company.model.Student;
import com.company.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudent")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){

        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/getStudent")
    public ResponseEntity<?> getAllStudent(){
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer id){
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("/editStudent/{id}")
    public ResponseEntity<?> editStudent(@RequestBody Student student, @PathVariable Integer id){
        return new ResponseEntity<>(studentService.editStudent(student, id), HttpStatus.CREATED);
    }

    @GetMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
        return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK);
    }


}
