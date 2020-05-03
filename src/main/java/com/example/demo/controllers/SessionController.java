package com.example.demo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(SessionController.API_PATH)
@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
public class SessionController {

    protected static final String API_PATH = "/api/Session";

    @GetMapping("/getAll")
    public List<String> getAll() {
        return WebSocketEventListener.sessions;
    }
}
