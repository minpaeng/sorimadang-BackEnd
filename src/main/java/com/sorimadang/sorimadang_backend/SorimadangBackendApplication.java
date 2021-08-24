package com.sorimadang.sorimadang_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SorimadangBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SorimadangBackendApplication.class, args);
    }

    /*@Bean
    public CommandLineRunner demo(UserService userService) {
        return (args) -> {
        };
    }*/
}