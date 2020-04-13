package com.example.demo.services;

import com.example.demo.model.Operator;
import com.example.demo.repository.OperatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorService {

    private final OperatorRepository operatorRepository;

    public OperatorService(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    public List<Operator> getAll() {
        return operatorRepository.findAll();
    }
}
