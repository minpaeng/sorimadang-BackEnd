package com.sorimadang.sorimadang_backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Getter
@Entity
@NoArgsConstructor
@IdClass(GameOXQuizKeys.class)
public class GameOXQuiz {
    @Id
    @Column(name = "stageNum", nullable = false)
    private int stageNum;

    @Id
    @Column(name = "quizNum", nullable = false)
    private int quizNum;

    @Column(nullable = false)
    private String quiz;

    @Column(nullable = false)
    private int answer;

    public GameOXQuiz(int stageNum, int quizNum, String quiz, int answer) {
        this.stageNum = stageNum;
        this.quizNum = quizNum;
        this.quiz = quiz;
        this.answer = answer;
    }
}