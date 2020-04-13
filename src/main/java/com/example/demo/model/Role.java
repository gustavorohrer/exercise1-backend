package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
@JsonIgnoreProperties("new")
public class Role extends AbstractPersistable<Long> {
    private String description;

    public String getDescription() {
        return description;
    }
}
