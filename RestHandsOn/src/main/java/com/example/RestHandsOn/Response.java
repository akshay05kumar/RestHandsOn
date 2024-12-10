package com.example.RestHandsOn;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Response {
    private String message;
    private String time;

    public Response(String message) {
        this.message = message;
        this.time = new Date().toString();
    }
}
