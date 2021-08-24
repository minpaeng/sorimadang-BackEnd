package com.sorimadang.sorimadang_backend.dto.wrongQuiz;

import com.sorimadang.sorimadang_backend.domain.GameOXQuiz;
import com.sorimadang.sorimadang_backend.domain.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WrongQuizRequestDto {
    private Long serialId;
    private User userId;
    private GameOXQuiz gameOXQuiz;
}
