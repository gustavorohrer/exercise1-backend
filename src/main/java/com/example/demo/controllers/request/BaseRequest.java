package com.example.demo.controllers.request;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BaseRequest {

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
