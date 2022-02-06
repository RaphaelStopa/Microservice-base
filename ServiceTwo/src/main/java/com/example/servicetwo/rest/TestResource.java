package com.example.servicetwo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/two")
public class TestResource {

    @GetMapping
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("TWO Works!", HttpStatus.OK);
    }
}
