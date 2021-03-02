package com.example.demo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test2Controller {
    
    @GetMapping
    public String getIndex(){
        return "index";
    }
}
