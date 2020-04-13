package com.example.demo.controllers.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class OperatorRequest extends BaseRequest {

    private final Long id;
    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;
    @NotNull
    private final String phone;
    @NotNull
    private final String email;
    @NotNull
    private final String password;
    @NotNull
    private final Long roleId;

    public OperatorRequest(@JsonProperty("id") Long id,
                           @JsonProperty("firstName") String firstName,
                           @JsonProperty("lastName") String lastName,
                           @JsonProperty("phone") String phone,
                           @JsonProperty("email") String email,
                           @JsonProperty("password") String password,
                           @JsonProperty("roleId") Long roleId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long getRoleId() {
        return roleId;
    }
}
