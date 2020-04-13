package com.example.demo.services;

import com.example.demo.controllers.request.OperatorRequest;
import com.example.demo.model.Operator;
import com.example.demo.model.Role;
import com.example.demo.repository.OperatorRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.services.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OperatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorService.class);

    private final OperatorRepository operatorRepository;
    private final RoleRepository roleRepository;

    public OperatorService(OperatorRepository operatorRepository, RoleRepository roleRepository) {
        this.operatorRepository = operatorRepository;
        this.roleRepository = roleRepository;
    }

    public List<Operator> getAll() {
        return operatorRepository.findAll();
    }

    public Response createOrUpdate(OperatorRequest dto) {
        Optional<Operator> optOperator = operatorRepository.findOneByEmail(dto.getEmail());
        if ((dto.getId() == null) && (optOperator.isPresent())) {
            return Response.forCode(ResponseCode.OPERATOR_ALREADY_EXIST);
        }

        Role role = roleRepository.findOne(dto.getRoleId());
        if (role == null) {
            LOGGER.error("The role with id: %s doesn't exist!", dto.getRoleId());
            return Response.forCode(ResponseCode.ROLE_NOT_EXIST);
        }

        Operator operator;
        ResponseCode responseCode;

        if (optOperator.isPresent()) {
            // Update
            operator = optOperator.get();
            responseCode = ResponseCode.OK;
        } else {
            // Create
            operator = new Operator();
            operator.setCreated(LocalDateTime.now());
            responseCode = ResponseCode.CREATED;
        }
        operator.setFirstName(dto.getFirstName());
        operator.setLastName(dto.getLastName());
        operator.setPhone(dto.getPhone());
        operator.setEmail(dto.getEmail());
        operator.setPassword(dto.getPassword());
        operator.setRole(role);

        operatorRepository.save(operator);
        return Response.forCode(responseCode);
    }

    public enum ResponseCode implements Response.ResponseCode {
        OK, CREATED, ROLE_NOT_EXIST, OPERATOR_ALREADY_EXIST;

        @Override
        public boolean isOk() {
            return this == OK || this == CREATED;
        }
    }
}
