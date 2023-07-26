package com.example.springbootEx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootEx.model.EmpDetails;
import com.example.springbootEx.repository.EmpRepo;

@Service
public class EmpService {
    
    @Autowired
    EmpRepo empRepo;


    
    public EmpDetails saveEmployee(EmpDetails empDetails) {
        EmpDetails empDetails2 = empRepo.save(empDetails);
        return empDetails2;
    }

    public List<EmpDetails> getAllEmployees(){
        return empRepo.findAll();
    }
    

    public void deleteEmployee(Integer id) {
        empRepo.deleteById(id);
    }

    public EmpDetails updateEmpDetails(Integer id, EmpDetails empDetails) {
        EmpDetails updateEmpDetails = empRepo.findById(id).get();
        updateEmpDetails.setName(empDetails.getName());
        updateEmpDetails.setAge(empDetails.getAge());
        updateEmpDetails.setMnumber(empDetails.getMnumber());
        updateEmpDetails.setAddress(empDetails.getAddress());
        updateEmpDetails.setSalary(empDetails.getSalary());
        return empRepo.save(updateEmpDetails);
    }

   
}
