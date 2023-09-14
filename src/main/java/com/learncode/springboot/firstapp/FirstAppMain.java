package com.learncode.springboot.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstAppMain {
    public static void main(String[] args) {
        SpringApplication.run(FirstAppMain.class, args);
        System.out.println("App is up and running");
    }
}
