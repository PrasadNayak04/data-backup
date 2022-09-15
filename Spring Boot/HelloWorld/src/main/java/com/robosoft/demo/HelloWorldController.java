package com.robosoft.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String hello()
    {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
