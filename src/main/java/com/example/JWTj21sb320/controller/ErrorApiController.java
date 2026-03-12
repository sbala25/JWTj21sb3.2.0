package com.example.JWTj21sb320.controller;

import com.example.JWTj21sb320.model.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorApiController {

    @PostMapping("/manualError")
    public String manualError() {
        throw new ArithmeticException("manual error");
    }
}
