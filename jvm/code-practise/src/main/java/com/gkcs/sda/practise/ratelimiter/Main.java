package com.gkcs.sda.practise.ratelimiter;

import com.gkcs.sda.practise.ratelimiter.models.Service;

import java.util.ArrayList;

public class Main {

    private static int SEVICE_INDEX = 0;
    private static final ArrayList<Service> REGISTERED_SERVICE = new ArrayList<>();

    private static void registerService(int serviceCapacity) {
        String serviceId = "service-" + ++SEVICE_INDEX;
        // add entry to REGISTERED_SERVICE
//        Service service = Service.Builder()
//                .serviceId(serviceId)
//                .capacity(serviceCapacity)
//                .build();
//        REGISTERED_SERVICE.add(service);
    }

    public static void main(String[] args) {

        // register the services
        int[] serviceCapacities = {20, 30, 40};
        // maintain the requests in an array

    }
}
