package com.kaiasia.bai5.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

//@RestController
//@Service
//@Repository
//@Component
//@RestController
@RestController
public class TestController {

    @PostMapping(value = "/hello")
    public String hello(@RequestBody String name){
        System.out.println(name);
        return "hello";
    }

}
