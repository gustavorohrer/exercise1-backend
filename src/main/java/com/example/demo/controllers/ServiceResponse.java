package com.example.demo.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashMap;
import java.util.Map;

public class ServiceResponse {

    private final Result result;
    private final String code;
    private final String message;
    private final Map<String, Object> extra;

    private ServiceResponse(Result result, String code, String message) {
        this.result = result;
        this.code = code;
        this.message = message;
        extra = new HashMap<>();
    }

    public Result getResult() {
        return result;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Object> getExtra() {
        return extra;
    }

    public void addAllExtra(Map<String, Object> extra) {
        this.extra.putAll(extra);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }

    public static ServiceResponse ok(String code, String message) {
        return new ServiceResponse(Result.OK, code, message);
    }

    public static ServiceResponse error(String code, String message) {
        return new ServiceResponse(Result.ERROR, code, message);
    }

    public enum Result {
        OK, ERROR
    }
}
