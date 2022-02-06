package com.example.serviceone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// Não colocar isto não apresenta problema, mas é bom para garantir.
@EnableEurekaClient
//Ver se coloca Scans
//@EntityScan({"com.example.shared.model"})
//@EnableJpaRepositories({"com.example.shared.repository"})
//@ComponentScan("com.example.shared")
public class ServiceOneApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOneApplication.class, args);
    }
}
