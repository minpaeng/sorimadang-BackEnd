package com.sorimadang.sorimadang_backend.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WrongQuizRequestDto {
    private Long serial_id;
    private User user_id;
    private GameOXQuiz gameOXQuiz;
}
