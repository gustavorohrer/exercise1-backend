package com.example.demo.controllers;

import com.example.demo.model.Operator;
import com.example.demo.services.OperatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(OperatorController.API_PATH)
public class OperatorController {

    protected static final String API_PATH = "/api/Operator";

    private final OperatorService operatorService;

    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @GetMapping("/test")
    public String test() {
        return "It's working";
    }

    @GetMapping("/getAll")
    public List<Operator> getAll() {
        return operatorService.getAll();
    }
}
