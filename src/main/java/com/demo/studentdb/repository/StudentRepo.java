package com.demo.studentdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.studentdb.model.StudentDetails;

public interface StudentRepo extends JpaRepository<StudentDetails, Integer>{
    
}
