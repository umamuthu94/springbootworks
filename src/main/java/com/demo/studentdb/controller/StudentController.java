package com.demo.studentdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.studentdb.model.StudentDetails;
import com.demo.studentdb.service.StudentService;

@RestController
public class StudentController {
   @Autowired
   StudentService service;

   @PostMapping("/update")
   public StudentDetails saveStudent(@RequestBody StudentDetails studentDetails) {
    StudentDetails studentDetails2 =service.saveStudent(studentDetails);
    return studentDetails2;
   }

   @GetMapping("/listOfStudents")
   public List<StudentDetails> getAllStudents(){
    return service.getAllStudents();
   }

   @PutMapping("/editStudentDeils")
   public ResponseEntity<StudentDetails> updateStudent(@PathVariable Integer id, @RequestBody StudentDetails updatedStudent) {
        StudentDetails updated = service.updateStudentDetails(id, updatedStudent);
        return ResponseEntity.ok(updated);
   }

   @DeleteMapping("/deletedetails")
   public void deleteStudent(Integer id) {
    service.deleteStudent(id);
   }
}
