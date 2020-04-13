package com.example.demo.controllers;

import com.example.demo.controllers.request.OperatorRequest;
import com.example.demo.services.OperatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(OperatorController.API_PATH)
public class OperatorController {

    protected static final String API_PATH = "/api/Operator";

    private final OperatorService operatorService;

    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @GetMapping("/getAll")
    public ServiceResponse getAll() {
        return operatorService.getAll().asServiceResponse();
    }

    @PostMapping("/createOrUpdate")
    public ServiceResponse createOrUpdate(@RequestBody @Valid OperatorRequest body) {
        return operatorService.createOrUpdate(body).asServiceResponse();
    }
}
