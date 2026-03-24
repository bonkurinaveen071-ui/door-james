package com.doorjames.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AuditService {

    public void log(String message) {
        System.out.println("AUDIT LOG: " + message);
    }
}