package com.sorimadang.sorimadang_backend.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WrongQuizRequestDto {
    private Long serialId;
    private User userId;
    private GameOXQuiz gameOXQuiz;
}
