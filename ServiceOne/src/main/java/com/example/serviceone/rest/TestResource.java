package com.example.serviceone.rest;

import com.example.shared.model.Shared;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.support.SharedEntityManagerBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
//Não precisa disto pq já coloquei no application
//@RequestMapping("/one")
//Ira roda na porta http://localhost:8081/one
public class TestResource {

    private static final String HELLO_SERVICE = "helloService";

    private RestTemplate restTemplate;

    // Tetse para ver se o artifact, esta ok no Pom
//    Shared nha = new Shared();


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

//        vi em um tudo que despois de resgitrado o cara conseguia por apenas o nome do service no local do localhost:8080 e continuava a dar certo
        // teste isto, ets em um TODO no cpnfigue

        String response = restTemplate.getForObject("http://TWO-SERVICE/two", String.class);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
    public ResponseEntity<String> helloFallback(Exception e){
        return new ResponseEntity<String>("Service is down", HttpStatus.OK);

    }
}
