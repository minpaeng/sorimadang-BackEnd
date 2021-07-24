package com.sorimadang.sorimadang_backend.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WrongQuizRequestDto {
    private WrongQuizKeys wrongQuizKeys;
    private String quiz;
    private int answer;
}
