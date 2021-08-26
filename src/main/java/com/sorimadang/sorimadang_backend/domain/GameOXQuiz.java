package com.sorimadang.sorimadang_backend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@IdClass(GameOXQuizKeys.class)
@Entity
public class GameOXQuiz {
    @Id
    @Column(nullable = false)
    private int stage_num;

    @Id
    @Column(nullable = false)
    private int quiz_num;

    @Column(nullable = false)
    private String quiz;

    @Column(nullable = false)
    private int answer;

    @Builder
    public GameOXQuiz(int stage_num, int quiz_num, String quiz, int answer) {
        this.stage_num = stage_num;
        this.quiz_num = quiz_num;
        this.quiz = quiz;
        this.answer = answer;
    }
}