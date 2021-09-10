package com.sorimadang.sorimadang_backend;

import com.sorimadang.sorimadang_backend.repository.UserRepository;
import com.sorimadang.sorimadang_backend.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SorimadangBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SorimadangBackendApplication.class, args);
    }

    /*@Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return (args) -> {
            userRepository.findAll();
        };
    }*/
}