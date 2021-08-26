package com.sorimadang.sorimadang_backend.dto.wrongQuiz;

import com.sorimadang.sorimadang_backend.domain.WrongQuiz;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;;

import java.util.List;

@NoArgsConstructor
@Getter
public class WrongQuizDto {
    private List<WrongQuiz> wrongQuizs;

    @Builder
    public WrongQuizDto(List<WrongQuiz> wrongQuizs) {
        this.wrongQuizs = wrongQuizs;
    }
}
