package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@JsonIgnoreProperties("new")
public class Operator extends User {

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Role role;

    public Role getRole() {
        return role;
    }
}
