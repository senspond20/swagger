package com.example.demo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 
public class SwaggerConfig { 
    @Bean 
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
        .select() 
        .apis(RequestHandlerSelectors.basePackage("com.example.demo")) 
        .paths(PathSelectors.any()) 
       // .paths(PathSelectors.ant("/v1/api/**")) // v1/api/ 인 URL만 필터링
        .build()
        .apiInfo(apiInfo())
        .enable(true);
    } 

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API 타이틀")
                .description("API 상세소개 및 사용법 등")
                .version("1.0")
                .build();
    }
    
    // private ApiInfo apiInfo() {
    //  return new ApiInfo(
    //      "TEST API", 
    //      "Some custom description of API.",
    //      "0.0.1", 
    //      "Terms of service", 
    //      new Contact("MemoStack", "https://memostack.tistory.com", "public.devhong@gmail.com"), 
    //      "License of API", 
    //      "API license URL", 
    //      Collections.emptyList()); 
    // } 
}

