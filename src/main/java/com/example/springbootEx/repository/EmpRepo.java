package com.example.springbootEx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootEx.model.EmpDetails;

public interface EmpRepo extends JpaRepository<EmpDetails,Integer> {
    
}
