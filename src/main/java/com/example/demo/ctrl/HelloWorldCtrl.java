package com.example.demo.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "inicio")
public class HelloWorldCtrl {


    @GetMapping
    public String inicio() {        
        return "Hello galera";
        
    }
}
