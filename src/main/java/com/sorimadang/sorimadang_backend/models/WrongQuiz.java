package com.sorimadang.sorimadang_backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class WrongQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private int stageNum;

    @Column(nullable = false)
    private int quizNum;

    @Column(nullable = false)
    private String quiz;

    @Column(nullable = false)
    private int answer;

    public WrongQuiz(String userId, int stageNum, int quizNum, String quiz, int answer) {
        this.userId = userId;
        this.stageNum = stageNum;
        this.quizNum = quizNum;
        this.quiz = quiz;
        this.answer = answer;
    }

    public WrongQuiz(WrongQuizRequestDto wrongQuizRequestDto) {
        this.userId = wrongQuizRequestDto.getUserId();
        this.stageNum = wrongQuizRequestDto.getStageNum();
        this.quizNum = wrongQuizRequestDto.getQuizNum();
        this.quiz = wrongQuizRequestDto.getQuiz();
        this.answer = wrongQuizRequestDto.getAnswer();
    }

}
