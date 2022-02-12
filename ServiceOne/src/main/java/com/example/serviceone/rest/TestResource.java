package com.example.serviceone.rest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.oauth2.jwt.Jwt;

@RestController
//Não precisa disto pq já coloquei no application
//@RequestMapping("/one")
//Ira roda na porta http://localhost:8081/one
public class TestResource {

    private static final String HELLO_SERVICE = "helloService";

    private RestTemplate restTemplate;

    // Teste para ver se o artifact, esta ok no Pom
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

        /* Toda esta parte seria so com o JWT
//        vi em um tudo que depois de resgitrado o cara conseguia por apenas o nome do service no local do localhost:8080 e continuava a dar certo
        // teste isto, em um TODO no configue

        String response = restTemplate.getForObject("http://TWO-SERVICE/two/", String.class);
        return new ResponseEntity<String>(response, HttpStatus.OK);
         */

//        Esta parte já é com o oauth2 e seria correto estar em um service

        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + jwt.getTokenValue());

        ResponseEntity<String> response = restTemplate.exchange("http://TWO-SERVICE/two/", HttpMethod.GET,new HttpEntity<>(httpHeaders), String.class);
        // TODO errado aqui
        return new ResponseEntity<String>(response.getBody(), HttpStatus.OK);
    }
    public ResponseEntity<String> helloFallback(Exception e){
        return new ResponseEntity<String>("Service is down", HttpStatus.OK);

    }
}
