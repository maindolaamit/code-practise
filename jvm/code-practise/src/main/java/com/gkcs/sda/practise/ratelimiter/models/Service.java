package com.gkcs.sda.practise.ratelimiter.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Service {
    String serviceId;
    int capacity;
    int timeout;
}
