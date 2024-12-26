package com.example.RestHandsOn.Models;

import java.util.Date;

public class Response {
    private String message;
    private String time;

    public Response(String message) {
        this.message = message;
        this.time = new Date().toString();
    }

    public String getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
