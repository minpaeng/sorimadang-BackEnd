package com.sorimadang.sorimadang_backend.models;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RequestTokenDto {
    private String idToken;
    private String refreshToken;

    @Builder
    public RequestTokenDto(String idToken, String refreshToken) {
        this.idToken = idToken;
        this.refreshToken = refreshToken;
    }
}
