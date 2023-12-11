package com.suraj.tt_crud.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellocontroller {

    @GetMapping("/")
    public String sayhello(){
        return "hello world";
    }

}
