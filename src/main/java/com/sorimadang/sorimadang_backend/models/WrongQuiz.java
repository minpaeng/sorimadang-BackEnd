package com.sorimadang.sorimadang_backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class WrongQuiz {
    /*@EmbeddedId
    protected WrongQuizKeys wrongQuizKeys;*/

    @Id
    private Long id;

    @Column(nullable = false)
    private int quizNum;

    @Column(nullable = false)
    private String quiz;

    @Column(nullable = false)
    private int answer;

    /*public WrongQuiz(WrongQuizKeys wrongQuizKeys, String quiz, int answer) {
        this.wrongQuizKeys = wrongQuizKeys;
        this.quiz = quiz;
        this.answer = answer;
    }*/

    public WrongQuiz(Long id, String quiz, int answer) {
        this.id = id;
        this.quiz = quiz;
        this.answer = answer;
    }

}
