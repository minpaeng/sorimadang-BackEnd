package com.sorimadang.sorimadang_backend.dto.wrongQuiz;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class DeleteNoteRequestDto {
    String idToken;
    private int stage_num;
    private int quiz_num;
}
