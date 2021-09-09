package com.sorimadang.sorimadang_backend.dto.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class NicknameUpdateRequestDto {
    private String idToken;
    private String nickname;
}
