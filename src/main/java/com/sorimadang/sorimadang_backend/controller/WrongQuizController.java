package com.sorimadang.sorimadang_backend.controller;

import com.sorimadang.sorimadang_backend.domain.GameOXQuiz;
import com.sorimadang.sorimadang_backend.domain.GameOXQuizKeys;
import com.sorimadang.sorimadang_backend.domain.User;
import com.sorimadang.sorimadang_backend.domain.WrongQuiz;
import com.sorimadang.sorimadang_backend.dto.wrongQuiz.DeleteNoteRequestDto;
import com.sorimadang.sorimadang_backend.dto.wrongQuiz.WrongNotesRequestDto;
import com.sorimadang.sorimadang_backend.dto.wrongQuiz.WrongQuizDto;
import com.sorimadang.sorimadang_backend.repository.GameOXQuizRepository;
import com.sorimadang.sorimadang_backend.repository.UserRepository;
import com.sorimadang.sorimadang_backend.repository.WrongQuizRepository;
import com.sorimadang.sorimadang_backend.dto.wrongQuiz.WrongQuizRequestDto;
import com.sorimadang.sorimadang_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
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
    @PostMapping("/api/ox-game/wrong-questions/save")
    public GameOXQuiz getUserWrongNotes(
            @RequestBody WrongQuizRequestDto requestDto) throws GeneralSecurityException, IOException {
        String email = userService.verifyToken(requestDto.getIdToken());

        //키 생성
        GameOXQuizKeys gameOXQuizKeys = GameOXQuizKeys.builder()
                .stage_num(requestDto.getStage_num())
                .quiz_num(requestDto.getQuiz_num())
                .build();

        //생성된 키에 해당하는 gameOXQuiz 찾기
        GameOXQuiz gameOXQuiz = gameOXQuizRepository.findById(gameOXQuizKeys)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 문제 문항입니다."));

        //해당 문제에 대한 오답노트가 이미 존재한다면(로직 구현)
        List<WrongQuiz> temp = wrongQuizRepository.findNote(email, requestDto.getStage_num(), requestDto.getQuiz_num());
        if(!temp.isEmpty()) throw new IllegalArgumentException("이미 오답노트에 존재하는 문항입니다.");

        //저장할 유저 가져오기
        User user = userRepository.findById(email).orElseThrow(
                ()->new IllegalArgumentException("잘못된 계정입니다.")
        );

        //유저(이메일)와 게임 객체화 및 저장
        WrongQuiz wrongQuiz = requestDto.toEntity(user, gameOXQuiz);
        wrongQuizRepository.save(wrongQuiz);

        return wrongQuiz.getGameOXQuiz();
    }

    //사용자 오답노트 검색
    @PostMapping("/api/ox-game/wrong-questions/search")
    public WrongQuizDto getNotes(@RequestBody WrongNotesRequestDto requestDto) throws GeneralSecurityException, IOException {
        String email = userService.verifyToken(requestDto.getIdToken());
        User user = userRepository.findById(email).orElseThrow(
                () -> new IllegalArgumentException("잘못된 접근입니다.")
        );

        WrongQuizDto wrongQuizDto = WrongQuizDto.builder().wrongQuizs(user.getWrongQuizs()).build();
        return wrongQuizDto;
    }

    // 오답노트에서 문제 제거
    @PostMapping("/api/ox-game/wrong-questions/remove")
    public Long deleteWrong(@RequestBody DeleteNoteRequestDto requestDto) throws GeneralSecurityException, IOException {
        String email = userService.verifyToken(requestDto.getIdToken());

        //오답노트생성이랑 코드 다 겹침 -> 함수로빼기
        //키 생성
        GameOXQuizKeys gameOXQuizKeys = GameOXQuizKeys.builder()
                .stage_num(requestDto.getStage_num())
                .quiz_num(requestDto.getQuiz_num())
                .build();

        //생성된 키에 해당하는 gameOXQuiz 찾기
        GameOXQuiz gameOXQuiz = gameOXQuizRepository.findById(gameOXQuizKeys)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 문제 문항입니다."));

        //해당 문제에 대한 오답노트가 이미 존재한다면(로직 구현)
        List<WrongQuiz> wrongQuizs = wrongQuizRepository.findNote(email, requestDto.getStage_num(), requestDto.getQuiz_num());
        if(wrongQuizs.isEmpty()) throw new IllegalArgumentException("오답노트에 존재하지 않는 문항입니다.");

        wrongQuizRepository.deleteById(wrongQuizs.get(0).getSerialId());
        return wrongQuizs.get(0).getSerialId();
    }
}



