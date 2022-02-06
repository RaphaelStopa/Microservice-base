package com.example.serviceone.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/one")
//Ira roda na porta http://localhost:8081/one
public class TestResource {

    @GetMapping
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("One Works!", HttpStatus.OK);
    }

//    private static final String ORDER_SERVICE = "orderService";
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Bean
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }
//
//    @GetMapping("/order")
//    @CircuitBreaker(name=ORDER_SERVICE, fallbackMethod = "orderFallback")
//    public ResponseEntity<String> createOrder(){
//        String response = restTemplate.getForObject("http://localhost:8081/item", String.class);
//        return new ResponseEntity<String>(response, HttpStatus.OK);
//    }
//    public ResponseEntity<String> orderFallback(Exception e){
//        return new ResponseEntity<String>("Item service is down", HttpStatus.OK);
//
//    }

}
