package com.example.demo.services.response;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Response getAll() {
        List<Role> roleList = roleRepository.findAll();
        return Response.forCode(ResponseCode.OK).withExtra("roleList", roleList);
    }

    public enum ResponseCode implements Response.ResponseCode {
        OK, CREATED;

        @Override
        public boolean isOk() {
            return this == OK || this == CREATED;
        }
    }
}
