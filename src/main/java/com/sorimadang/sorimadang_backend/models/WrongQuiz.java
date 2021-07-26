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
    private Long serial_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user_id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "stageNum", referencedColumnName = "stageNum", nullable = false),
            @JoinColumn(name = "quizNum", referencedColumnName = "quizNum", nullable = false)
    })
    private GameOXQuiz gameOXQuiz;

    public WrongQuiz(WrongQuizRequestDto wrongQuizRequestDto) {
        this.user_id = wrongQuizRequestDto.getUser_id();
        this.gameOXQuiz = wrongQuizRequestDto.getGameOXQuiz();
    }

}
