package com.example.demo.services.response;


import com.example.demo.controllers.ServiceResponse;

import java.util.HashMap;
import java.util.Map;

public class Response {

    private final ResponseCode responseCode;
    private final Map<String, Object> extra;

    private Response(ResponseCode responseCode) {
        this.responseCode = responseCode;
        extra = new HashMap<>();
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void addExtra(String key, Object value) {
        extra.put(key, value);
    }

    public Response withExtra(String key, Object value) {
        extra.put(key, value);
        return this;
    }

    public Response mergeExtra(String label, Response other) {
        extra.put(label, other.getExtra());
        return this;
    }

    public <T> T getExtra(String name, Class<T> type) {
        return type.cast(extra.get(name));
    }

    public static Response forCode(ResponseCode responseCode) {
        return new Response(responseCode);
    }

    public boolean isOk() {
        return responseCode.isOk();
    }

    public ServiceResponse asServiceResponse() {
        ServiceResponse serviceResponse = responseCode.isOk() ? ServiceResponse.ok(responseCode.name(), null) : ServiceResponse.error(responseCode.name(), null);
        serviceResponse.addAllExtra(extra);
        return serviceResponse;
    }

    public interface ResponseCode {

        boolean isOk();

        String name();
    }
}
