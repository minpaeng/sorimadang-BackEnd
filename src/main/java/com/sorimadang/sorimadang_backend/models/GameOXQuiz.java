package com.sorimadang.sorimadang_backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class GameOXQuiz {
    @Id
    private String id;

    @Column(nullable = false)
    private int stageNum;

    @Column(nullable = false)
    private int quizNum;

    @Column(nullable = false)
    private String quiz;

    @Column(nullable = false)
    private int answer;

    public GameOXQuiz(String id, int stageNum, int quizNum, String quiz, int answer) {
        this.id = id;
        this.stageNum = stageNum;
        this.quizNum = quizNum;
        this.quiz = quiz;
        this.answer = answer;
    }
}