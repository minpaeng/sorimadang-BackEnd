package com.sorimadang.sorimadang_backend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class GameOXQuizKeys implements Serializable {
    private int stageNum;
    private int quizNum;

    @Builder
    public GameOXQuizKeys(int stageNum, int quizNum) {
        this.stageNum = stageNum;
        this.quizNum = quizNum;
    }
}
