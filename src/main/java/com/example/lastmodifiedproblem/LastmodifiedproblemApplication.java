package com.example.lastmodifiedproblem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LastmodifiedproblemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LastmodifiedproblemApplication.class, args);
    }

}
