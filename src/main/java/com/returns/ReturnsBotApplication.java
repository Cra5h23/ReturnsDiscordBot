package com.returns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Nikolay Radzivon
 * @Date 20.08.2024
 */
@SpringBootApplication
@EnableScheduling
public class ReturnsBotApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReturnsBotApplication.class, args);
    }
}