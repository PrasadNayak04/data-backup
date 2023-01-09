package com.robosoft.user_service.controller;

import com.robosoft.user_service.VO.ResponseTemplate;
import com.robosoft.user_service.entity.User;
import com.robosoft.user_service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableEurekaClient
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User addDepartment(@RequestBody User department){
        log.info("inside add user");
        return userService.addUser(department);
    }

    @GetMapping("/{id}")
    public ResponseTemplate getDepartmentById(@PathVariable("id") Long userId){
        log.info("inside find user with department");
        return userService.getUserDetailsByUserId(userId);
    }

}
