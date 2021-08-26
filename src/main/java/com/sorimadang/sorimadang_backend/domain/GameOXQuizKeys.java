package com.sorimadang.sorimadang_backend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class GameOXQuizKeys implements Serializable {
    private int stage_num;
    private int quiz_num;

    @Builder
    public GameOXQuizKeys(int stage_num, int quiz_num) {
        this.stage_num = stage_num;
        this.quiz_num = quiz_num;
    }
}
