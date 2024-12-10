package com.example.RestHandsOn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class APIController {

    @GetMapping("/api/hello")
    public Response hello() {
        return new Response("Hello from first API");
    }
}
