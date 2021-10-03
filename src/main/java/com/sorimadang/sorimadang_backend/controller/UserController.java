package com.sorimadang.sorimadang_backend.controller;

import com.sorimadang.sorimadang_backend.domain.User;
import com.sorimadang.sorimadang_backend.dto.user.DeleteRequestDto;
import com.sorimadang.sorimadang_backend.dto.user.LoginRequestDto;
import com.sorimadang.sorimadang_backend.dto.user.NicknameUpdateRequestDto;
import com.sorimadang.sorimadang_backend.repository.UserRepository;
import com.sorimadang.sorimadang_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class UserController{
    private final UserRepository userRepository;
    private final UserService userService;

    // 회원정보 조회
    @GetMapping("/api/users")
    public List<User> getUser() {
        return userRepository.findAll();
    }

    // 닉네임 수정
    @PutMapping("/api/user")
    public String updateNickname(@RequestBody NicknameUpdateRequestDto requestDto) throws GeneralSecurityException, IOException {
        return userService.update(requestDto);
    }

    /*// 회원 탈퇴
    @DeleteMapping("/api/user")
    public String deleteUser(@RequestBody DeleteRequestDto requestDto) throws GeneralSecurityException, IOException {
        //토큰 검증 및 email 리턴받기
        String email = userService.verifyToken(requestDto.getIdToken());
        User user = userRepository.findById(email)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 계정이 없습니다."));
        userRepository.delete(user);
        return email;
    }*/

    //로그인: 토큰 입력
    @PostMapping("/api/user")
    public String login(@RequestBody LoginRequestDto requestDto) throws GeneralSecurityException, IOException {
        String email = userService.verifyToken(requestDto.getIdToken());
        if(email == null) throw new IOException("잘못된 접근입니다.");
        Optional<User> user = userRepository.findById(email);
        if(!user.isPresent()) {
            userRepository.save(requestDto.toEntity(email));
        }
        return email;
    }
}