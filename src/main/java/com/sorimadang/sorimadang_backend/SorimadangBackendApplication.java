package com.sorimadang.sorimadang_backend;

import com.sorimadang.sorimadang_backend.models.*;
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

    @Bean
    public CommandLineRunner demo(UserRepository userRepository, GameOXQuizRepository gameOXQuizRepository) {
        return (args) -> {
            // 유저 정보 추가
            userRepository.save(new User("yeopx2", "ramram", "엽엽"));
            userRepository.save(new User("hihi12", "hello123", ""));
            userRepository.save(new User("jiyeah3108", "jiye215", "람지"));

            // 문제 추가
            gameOXQuizRepository.save(new GameOXQuiz(1, 1, "가야금은 12줄이다.", 1));
            gameOXQuizRepository.save(new GameOXQuiz(1, 2, "가야금은 1줄이다.", 0));

            System.out.println("성공");
        };
    }

}
