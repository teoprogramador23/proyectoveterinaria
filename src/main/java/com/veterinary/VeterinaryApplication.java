package com.veterinary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VeterinaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(VeterinaryApplication.class, args);
        System.out.println("Veterinary Application is running...");
    }
}

