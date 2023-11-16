package com.gkcs.sda.practise.ratelimiter.models;


import lombok.Data;

@Data
public class Request {
    String ipAddress;
    int timeout;
    String requestBody;
}
