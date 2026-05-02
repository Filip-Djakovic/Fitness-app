package org.unibl.etf.ipback.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public String getHello(){
        return "Hello world from spring";
    }
}
