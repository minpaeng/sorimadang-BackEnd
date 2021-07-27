package com.sorimadang.sorimadang_backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "WRONGQUIZ")
@NoArgsConstructor
public class WrongQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long serialId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "stageNum", referencedColumnName = "stageNum", nullable = false),
            @JoinColumn(name = "quizNum", referencedColumnName = "quizNum", nullable = false)
    })
    private GameOXQuiz gameOXQuiz;

    public WrongQuiz(WrongQuizRequestDto wrongQuizRequestDto) {
        this.userId = wrongQuizRequestDto.getUserId();
        this.gameOXQuiz = wrongQuizRequestDto.getGameOXQuiz();
    }

}
