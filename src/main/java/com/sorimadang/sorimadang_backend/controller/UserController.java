package com.sorimadang.sorimadang_backend.controller;

import com.sorimadang.sorimadang_backend.models.*;
import com.sorimadang.sorimadang_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserRepository userRepository;
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

    // 로그인 -> 그 회원의 오답 정보 가져와야 함
    @PostMapping("/api/users/login/{id}")
    public List<WrongQuiz> getUser(@PathVariable String id,@RequestBody UserRequestDto requestDto) {
        return wrongQuizRepository.findAllByUserId(id);

    }

    // 닉네임 수정
    @PutMapping("api/users")
    public String updateNickname(@RequestBody UserRequestDto requestDto) {
        return userService.update(requestDto.getUser_id(), requestDto);
    }
}
