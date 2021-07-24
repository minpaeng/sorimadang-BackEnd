package com.sorimadang.sorimadang_backend;

import com.sorimadang.sorimadang_backend.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class SorimadangBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SorimadangBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository, GameOXQuizRepository gameOXQuizRepository, WrongQuizRepository wrongQuizRepository) {
        return (args) -> {
            userRepository.save(new User("dodo", "sdfdsf", "도드리"));
            gameOXQuizRepository.save(new GameOXQuiz("11", 1, 1, "가야금은 12줄이다.", 1));
            gameOXQuizRepository.save(new GameOXQuiz("12", 1, 2, "가야금은 1줄이다.", 0));
            wrongQuizRepository.save(new WrongQuiz("dodo", 1, 1, "가야금은 12줄이다.", 1));

            System.out.println("데이터 인쇄");
            List<GameOXQuiz> quizList = gameOXQuizRepository.findAll();
            for (int i=0; i<quizList.size(); i++) {
                GameOXQuiz gameOXQuiz = quizList.get(i);
                System.out.println(gameOXQuiz.getId());
                System.out.println(gameOXQuiz.getStageNum());
                System.out.println(gameOXQuiz.getQuizNum());
                System.out.println(gameOXQuiz.getQuiz());
                System.out.println(gameOXQuiz.getAnswer());
            }
        };
    }

}
