package com.example.servicetwo.rest;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/two")
//Ira roda na porta http://localhost:8082/two
@EnableEurekaClient
public class TestResource {

    @GetMapping
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("TWO Works!", HttpStatus.OK);
    }
}
