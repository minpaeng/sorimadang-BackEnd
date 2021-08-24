package com.sorimadang.sorimadang_backend.controller;

import com.sorimadang.sorimadang_backend.domain.WrongQuiz;
import com.sorimadang.sorimadang_backend.repository.WrongQuizRepository;
import com.sorimadang.sorimadang_backend.dto.wrongQuiz.WrongQuizRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class WrongQuizController {
    private final WrongQuizRepository wrongQuizRepository;

    // 오답노트 가져오기
    @GetMapping("/api/ox-game/wrong-questions")
    public List<WrongQuiz> getWrong() {
        return wrongQuizRepository.findAll();
    }

    // 오답노트에 문제 추가
    @PostMapping("/api/ox-game/wrong-questions")
    public WrongQuiz createWrong(@RequestBody WrongQuizRequestDto requestDto) {
        WrongQuiz wrongQuiz = new WrongQuiz(requestDto);
        return wrongQuizRepository.save(wrongQuiz);
    }

    /*// 오답노트에서 문제 제거
    @DeleteMapping("/api/ox-game/wrong-questions/{id}")
    public void deleteWrong(@PathVariable )*/

}



