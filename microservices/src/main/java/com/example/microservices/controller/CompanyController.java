package com.example.microservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    
    @GetMapping("/company")
    public String companydetails() {
        return "Zaga";
    }
}
