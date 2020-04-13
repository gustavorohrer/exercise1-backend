package com.example.demo;

import com.example.demo.model.Operator;
import com.example.demo.model.Role;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.Serializable;

public abstract class TestUtils {

    private TestUtils() {
    }

    public static <T extends Serializable> void setId(AbstractPersistable<T> persistable, T id) {
        ReflectionTestUtils.setField(persistable, "id", id);
    }

    public static Role createRole() {
        Role role = new Role();
        setId(role, 1L);
        ReflectionTestUtils.setField(role, "description", "Test Role");
        return role;
    }

    public static Operator createOperator() {
        Operator operator = new Operator();
        setId(operator, 1L);
        operator.setFirstName("Gustavo");
        operator.setLastName("Rohrer");
        operator.setPhone("221 5701404");
        operator.setEmail("gustavorohrer@gmail.com");
        operator.setEmail("password");
        operator.setRole(createRole());
        return operator;
    }
}
