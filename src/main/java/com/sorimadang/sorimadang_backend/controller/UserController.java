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

    @GetMapping("/api/users")
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @PostMapping("/api/users/signup")
    public User createUser(@RequestBody UserRequestDto requestDto) {
        User user = new User(requestDto);
        return userRepository.save(user);
    }

    /*@PostMapping("/api/users/login")
    public WrongQuiz getUser(@RequestBody UserRequestDto requestDto) {
        List<User> user = wrongQuizRepository.
    }*/

    @PutMapping("api/users")
    public String updateNickname(@RequestBody UserRequestDto requestDto) {
        return userService.update(requestDto.getUser_id(), requestDto);
    }
}
