package com.sorimadang.sorimadang_backend.controller;

import com.sorimadang.sorimadang_backend.models.*;
import com.sorimadang.sorimadang_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController{
    private final UserRepository userRepository;
    @Autowired
    private final WrongQuizRepository wrongQuizRepository;
    private final UserService userService;

    // 회원정보 조회
    @GetMapping("/api/users")
    public List<User> getUser() {
        return userRepository.findAll();
    }

    // 닉네임 수정
    @PutMapping("api/users")
    public String updateNickname(@RequestBody UserRequestDto requestDto) {
        return userService.update(requestDto.getUserId(), requestDto);
    }

    //토큰 입력
    /*@PostMapping("/tokensignin")
    public void sendToken(@RequestBody String idToken) {
        userService.validateToken();
        if(userService.isUser()) {
            userService.saveUser();
        } else {

        }
    }*/
}