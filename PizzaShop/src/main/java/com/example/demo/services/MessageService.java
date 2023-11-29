package com.example.demo.services;

import org.springframework.stereotype.Component;

@Component
public class MessageService {

    public String getMessage(String initialMsg) {
        return initialMsg + " (approved by Spring!)";
    }
}
