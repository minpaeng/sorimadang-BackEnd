package com.sorimadang.sorimadang_backend.controller;

import com.sorimadang.sorimadang_backend.domain.GameOXQuiz;
import com.sorimadang.sorimadang_backend.domain.GameOXQuizKeys;
import com.sorimadang.sorimadang_backend.domain.User;
import com.sorimadang.sorimadang_backend.domain.WrongQuiz;
import com.sorimadang.sorimadang_backend.repository.GameOXQuizRepository;
import com.sorimadang.sorimadang_backend.repository.UserRepository;
import com.sorimadang.sorimadang_backend.repository.WrongQuizRepository;
import com.sorimadang.sorimadang_backend.dto.wrongQuiz.WrongQuizRequestDto;
import com.sorimadang.sorimadang_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class WrongQuizController {
    private final WrongQuizRepository wrongQuizRepository;
    private final GameOXQuizRepository gameOXQuizRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    // 전체 오답노트 가져오기
    @GetMapping("/api/ox-game/wrong-questions")
    public List<WrongQuiz> getWrong() {
        return wrongQuizRepository.findAll();
    }

    //사용자 오답노트 저장하기
    @PostMapping("/api/ox-game/wrong-questions")
    public WrongQuiz getUserWrongNotes(
            @RequestBody WrongQuizRequestDto requestDto) throws GeneralSecurityException, IOException {
        String email = userService.verifyToken(requestDto.getIdToken());
        GameOXQuizKeys gameOXQuizKeys = GameOXQuizKeys.builder()
                .stageNum(requestDto.getStageNum())
                .quizNum(requestDto.getQuizNum())
                .build();
        GameOXQuiz gameOXQuiz = gameOXQuizRepository.findById(gameOXQuizKeys)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 문제 문항입니다."));

        //해당 문제에 대한 오답노트가 존재하지 않는다면(로직 구현)
        User user = userRepository.findById(email).orElseThrow(
                ()->new IllegalArgumentException("잘못된 계정입니다."
                )
        );
        return requestDto.toEntity(user, gameOXQuiz);
    }

    /*// 오답노트에 문제 추가
    @PostMapping("/api/ox-game/wrong-questions")
    public WrongQuiz createWrong(@RequestBody WrongQuizRequestDto requestDto) {
        WrongQuiz wrongQuiz = new WrongQuiz(requestDto);
        return wrongQuizRepository.save(wrongQuiz);
    }*/

    /*// 오답노트에서 문제 제거
    @DeleteMapping("/api/ox-game/wrong-questions/{id}")
    public void deleteWrong(@PathVariable )*/

}



