package com.sorimadang.sorimadang_backend.domain;

import com.sorimadang.sorimadang_backend.domain.GameOXQuiz;
import com.sorimadang.sorimadang_backend.domain.User;
import com.sorimadang.sorimadang_backend.dto.wrongQuiz.WrongQuizRequestDto;
import lombok.Builder;
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
    @JoinColumn(name = "email", nullable = false)
    private User email;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "stageNum", referencedColumnName = "stageNum", nullable = false),
            @JoinColumn(name = "quizNum", referencedColumnName = "quizNum", nullable = false)
    })
    private GameOXQuiz gameOXQuiz;

    @Builder
    public WrongQuiz(User email, GameOXQuiz gameOXQuiz) {
        this.email = email;
        this.gameOXQuiz = gameOXQuiz;
    }

}
