package com.example.serviceone.rest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
//@RequestMapping("/one")
//Ira roda na porta http://localhost:8081/one
public class TestResource {

    private static final String HELLO_SERVICE = "helloService";

//    private static final String ORDER_SERVICE = "orderService";
//
//    @Bean
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }


    private RestTemplate restTemplate;

    public TestResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("One Works!", HttpStatus.OK);
    }


    //http://localhost:8081/one/hello
    @GetMapping("/hello")
    @CircuitBreaker(name= HELLO_SERVICE, fallbackMethod = "helloFallback")
    public ResponseEntity<String> sayHello(){
        String response = restTemplate.getForObject("http://localhost:8082/two", String.class);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
    public ResponseEntity<String> helloFallback(Exception e){
        return new ResponseEntity<String>("Service is down", HttpStatus.OK);

    }

//    @GetMapping("/order")
//    @CircuitBreaker(name=ORDER_SERVICE, fallbackMethod = "orderFallback")
//    public ResponseEntity<String> createOrder(){
//        String response = restTemplate.getForObject("http://localhost:8082/two", String.class);
//        return new ResponseEntity<String>(response, HttpStatus.OK);
//    }
//    public ResponseEntity<String> orderFallback(Exception e){
//        return new ResponseEntity<String>("Item service is down", HttpStatus.OK);
//
//    }


}
