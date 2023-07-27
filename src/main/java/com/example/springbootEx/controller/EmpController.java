package com.example.springbootEx.controller;

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
import org.springframework.web.client.RestTemplate;

import com.example.springbootEx.model.EmpDetails;
import com.example.springbootEx.service.EmpService;

@RestController
public class EmpController {
    
    @Autowired
    private RestTemplate restTemplate;
    EmpService service;

    @PostMapping("/create")
    public EmpDetails saveEmployee(@RequestBody EmpDetails empDetails) {
       EmpDetails empDetails2 = service.saveEmployee(empDetails);
       return empDetails2; 
    }

    @GetMapping("/listOfEmployee")
     public List<EmpDetails> getAllEmployees() {
        return service.getAllEmployees();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<EmpDetails> updateEmployee(@PathVariable Integer id, @RequestBody EmpDetails updateEmployee) {
        EmpDetails updated = service.updateEmpDetails(id, updateEmployee);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/deletedetails")
    public void deleteEmployee(Integer id) {
        service.deleteEmployee(id);
    }

    @GetMapping("/name")
    public String companyname() {
     String companydetails = restTemplate.getForObject("http://localhost:8082/company",String.class);
    return companydetails;
    }

}
