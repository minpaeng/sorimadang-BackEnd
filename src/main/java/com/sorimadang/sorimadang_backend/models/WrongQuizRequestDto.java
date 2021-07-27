package com.sorimadang.sorimadang_backend.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WrongQuizRequestDto {
    private String userId;
    private int stageNum;
    private int quizNum;
    private String quiz;
    private int answer;
}
