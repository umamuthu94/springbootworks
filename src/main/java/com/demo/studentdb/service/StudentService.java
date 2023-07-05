package com.demo.studentdb.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.studentdb.model.StudentDetails;
import com.demo.studentdb.repository.StudentRepo;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public StudentDetails saveStudent(StudentDetails studentDetails) {
    StudentDetails studentDetails1 = studentRepo.save(studentDetails);
    return studentDetails1;
    }

    public List<StudentDetails> getAllStudents(){
        return studentRepo.findAll();
    }


    public void deleteStudent(Integer id) {
    studentRepo.deleteById(id);
    }

    public StudentDetails updateStudentDetails(Integer id, StudentDetails studentDetails) {
        StudentDetails updateStudentDetails = studentRepo.findById(id).get();
        updateStudentDetails.setName(studentDetails.getName());
        updateStudentDetails.setDepartment(studentDetails.getDepartment());
        updateStudentDetails.setMnumber(studentDetails.getMnumber());
        updateStudentDetails.setEmail(studentDetails.getEmail());
        updateStudentDetails.setAddress(studentDetails.getAddress());
        updateStudentDetails.setYearofstudy(studentDetails.getYearofstudy());
        return studentRepo.save(updateStudentDetails);
    }
}
