package com.example.inputhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class InputHandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InputHandlerApplication.class, args);
    }

}
