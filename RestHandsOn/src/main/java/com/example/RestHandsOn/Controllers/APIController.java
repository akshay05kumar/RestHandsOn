package com.example.RestHandsOn.Controllers;

import com.example.RestHandsOn.Models.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    @GetMapping(value = "/api/hello")
    public Response hello() {
        return new Response("Hello from first API");
    }
}
