package com.example.demo.test;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.google.common.net.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="swagger-rest-controller", description = "swagger") // Controller에 대한 Swagger 설명
@RequestMapping("/api/v1") 
public class TestController {

    @ApiOperation(  // API에 대한 Swagger 설명
        value="서비스",
        notes = "서비스입니다.",
        httpMethod = "GET",
        consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        responseHeaders = {
                //headers
    }) 
    @ApiResponses({  // Response Message에 대한 Swagger 설명
        @ApiResponse(code = 200, message = "OK"),
    })
    @GetMapping("user/search") 
    public Map<String, String> search() { 
        Map<String, String> response = new HashMap<String, String>(); 
        response.put("name", "taehong.kim"); 
        response.put("age", "28"); 
        response.put("email", "xxxxxxxx@gmail.com"); 
        return response; 
    } 
    
    @GetMapping(value = "/home/{area}")
    public String home(@PathVariable String area, @RequestParam String param1, @RequestParam int param2) {
        return "home";
    }
 
}

