package com.sorimadang.sorimadang_backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class WrongQuiz {
    @EmbeddedId
    protected WrongQuizKeys wrongQuizKeys;

    @Column(nullable = false)
    private String quiz;

    @Column(nullable = false)
    private int answer;

    public WrongQuiz(WrongQuizKeys wrongQuizKeys, String quiz, int answer) {
        this.wrongQuizKeys = wrongQuizKeys;
        this.quiz = quiz;
        this.answer = answer;
    }

    public WrongQuiz(WrongQuizRequestDto wrongQuizRequestDto) {
        this.wrongQuizKeys = wrongQuizRequestDto.getWrongQuizKeys();
        this.quiz = wrongQuizRequestDto.getQuiz();
        this.answer = wrongQuizRequestDto.getAnswer();
    }

}
