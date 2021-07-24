package com.sorimadang.sorimadang_backend.controller;

import com.sorimadang.sorimadang_backend.models.*;
import com.sorimadang.sorimadang_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @PostMapping("/api/users/login")
    public List<WrongQuiz> getUser(@RequestBody UserRequestDto requestDto) {
        /*List<User> users = userRepository.findByUser_id(id);
        String pw = null;
        for(int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            pw = user.getPassword();
        }
        if(requestDto.getPassword() == pw) {
            return wrongQuizRepository.findAllByUserId(id);
        }
        else {
          WrongQuiz wrongQuiz = new WrongQuiz(id, 0, 0, "로그인 실패", 0);
          List<WrongQuiz> list = new ArrayList<WrongQuiz>();
          list.add(wrongQuiz);
            return list;
        }*/
        return wrongQuizRepository.findAllByUserId(requestDto.getUser_id());
    }

    // 닉네임 수정
    @PutMapping("api/users")
    public String updateNickname(@RequestBody UserRequestDto requestDto) {
        return userService.update(requestDto.getUser_id(), requestDto);
    }
}
