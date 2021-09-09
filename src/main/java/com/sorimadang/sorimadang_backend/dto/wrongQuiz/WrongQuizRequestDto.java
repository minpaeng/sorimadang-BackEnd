package com.sorimadang.sorimadang_backend.dto.wrongQuiz;

import com.sorimadang.sorimadang_backend.domain.GameOXQuiz;
import com.sorimadang.sorimadang_backend.domain.User;
import com.sorimadang.sorimadang_backend.domain.WrongQuiz;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class WrongQuizRequestDto {
    private String idToken;
    private int stage_num;
    private int quiz_num;

    public WrongQuiz toEntity(User user, GameOXQuiz gameOXQuiz) {
        return WrongQuiz.builder()
                .email(user)
                .gameOXQuiz(gameOXQuiz)
                .build();
    }
}
