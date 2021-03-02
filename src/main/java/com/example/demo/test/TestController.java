package com.example.demo.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value="swagger-rest-controller", description = "swagger")
@RequestMapping("/api/v1") 
public class TestController { 
    @GetMapping("user/search") 
    public Map<String, String> search() { 
        Map<String, String> response = new HashMap<String, String>(); 
        response.put("name", "taehong.kim"); 
        response.put("age", "28"); 
        response.put("email", "xxxxxxxx@gmail.com"); 
        return response; 
    } 

 
}

