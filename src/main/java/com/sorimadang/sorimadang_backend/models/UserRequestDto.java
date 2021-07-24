package com.sorimadang.sorimadang_backend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String user_id;
    private String password;
    private String nickname;
}
