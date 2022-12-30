package com.robosoft.APIGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/department-service-fallback")
    public String departmentServiceFallbackMethod(){
        return "Department services are down.";
    }

    @GetMapping("/user-service-fallback")
    public String userServiceFallbackMethod(){
        return "User services are down.";
    }

}
