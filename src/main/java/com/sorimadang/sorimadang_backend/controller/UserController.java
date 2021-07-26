package com.sorimadang.sorimadang_backend.controller;

import com.sorimadang.sorimadang_backend.models.*;
import com.sorimadang.sorimadang_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserRepository userRepository;
    @Autowired
    private final WrongQuizRepository wrongQuizRepository;
    private final UserService userService;

    // 회원정보 조회
    @GetMapping("/api/users")
    public List<User> getUser() {
        return userRepository.findAll();
    }

    // 회원가입
    @PostMapping("/api/users/signup")
    public User createUser(@RequestBody UserRequestDto requestDto) {
        User user = new User(requestDto);
        return userRepository.save(user);
    }

    // 로그인 -> 아이디, 비번 체크 & 그 회원의 오답 정보 가져와야 함
    @PostMapping("/api/users/login")
    public List<WrongQuiz> getUser(@RequestBody UserRequestDto requestDto) {
        //return wrongQuizRepository.findAllByUserId(requestDto.getUser_id());


        String name = requestDto.getUser_id();
        System.out.println("유저아이디 : " + name);
        return wrongQuizRepository.findByUserId(name);

    }

    // 닉네임 수정
    @PutMapping("api/users")
    public String updateNickname(@RequestBody UserRequestDto requestDto) {
        return userService.update(requestDto.getUser_id(), requestDto);
    }
}
