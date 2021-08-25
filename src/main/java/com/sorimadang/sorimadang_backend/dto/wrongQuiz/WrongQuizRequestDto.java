package com.sorimadang.sorimadang_backend.dto.wrongQuiz;

import com.sorimadang.sorimadang_backend.domain.GameOXQuiz;
import com.sorimadang.sorimadang_backend.domain.User;
import com.sorimadang.sorimadang_backend.domain.WrongQuiz;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class WrongQuizRequestDto {
    private Long serialId;
    private String idToken;
    private int stageNum;
    private int quizNum;

    public WrongQuiz toEntity(User user, GameOXQuiz gameOXQuiz) {
        return WrongQuiz.builder()
                .email(user)
                .gameOXQuiz(gameOXQuiz)
                .build();
    }
}
