package com.sorimadang.sorimadang_backend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "email", nullable = false)
    private User email;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "stage_num", referencedColumnName = "stage_num", nullable = false),
            @JoinColumn(name = "quiz_num", referencedColumnName = "quiz_num", nullable = false)
    })
    private GameOXQuiz gameOXQuiz;

    @Builder
    public WrongQuiz(User email, GameOXQuiz gameOXQuiz) {
        this.email = email;
        this.gameOXQuiz = gameOXQuiz;
    }
}
