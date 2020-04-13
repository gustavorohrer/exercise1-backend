package com.example.demo.controllers;

import com.example.demo.services.response.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RoleController.API_PATH)
public class RoleController {

    protected static final String API_PATH = "/api/Role";

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/getAll")
    public ServiceResponse getAll() {
        return roleService.getAll().asServiceResponse();
    }
}
