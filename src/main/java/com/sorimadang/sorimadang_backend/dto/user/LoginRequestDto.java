package com.sorimadang.sorimadang_backend.dto.user;

import com.sorimadang.sorimadang_backend.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LoginRequestDto {
    private String idToken;

    public User toEntity(String email) {
        return User.builder()
                .email(email)
                .nickname(null)
                .build();
    }
}
