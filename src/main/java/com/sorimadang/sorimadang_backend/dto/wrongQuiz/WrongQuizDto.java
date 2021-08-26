package com.sorimadang.sorimadang_backend.dto.wrongQuiz;

import com.sorimadang.sorimadang_backend.domain.WrongQuiz;;

import java.util.List;

public class WrongQuizDto {
    private List<WrongQuiz> wrongQuizs;

    private WrongQuizDto() {
    }

    public WrongQuizDto(List<WrongQuiz> wrongQuizs) {
        this.wrongQuizs = wrongQuizs;
    }

    public List<WrongQuiz> getWrongQuizs() {
        return this.wrongQuizs;
    }
}
