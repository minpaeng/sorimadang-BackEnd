package com.sorimadang.sorimadang_backend.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class DeleteRequestDto {
    private String idToken;
}
