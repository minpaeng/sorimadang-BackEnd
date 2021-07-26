package com.sorimadang.sorimadang_backend.controller;

import com.sorimadang.sorimadang_backend.models.*;
import com.sorimadang.sorimadang_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController extends LoginCheck{
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
        return loginCheck(userRepository, wrongQuizRepository, requestDto);
    }

    // 닉네임 수정
    @PutMapping("api/users")
    public String updateNickname(@RequestBody UserRequestDto requestDto) {
        return userService.update(requestDto.getUser_id(), requestDto);
    }
}

class LoginCheck{
    //로그인 성공 여부 확인
    protected List<WrongQuiz> loginCheck(
            UserRepository userRepository, WrongQuizRepository wrongQuizRepository, UserRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUser_id()).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        String pw = user.getPassword();
        if(requestDto.getPassword().equals(pw)) {
            return wrongQuizRepository.findByUserId(requestDto.getUser_id());
        }
        else {
            System.out.println("비밀번호가 틀렸습니다. ");
            return null;
        }
    }
}