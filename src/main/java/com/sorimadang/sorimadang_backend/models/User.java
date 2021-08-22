package com.sorimadang.sorimadang_backend.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//자동 접속 시간 구현 추가 잊지말기
@Getter
@NoArgsConstructor
@Entity
public class User{
    @Id
    private String userId;

    @Column
    private String nickname;

    @Column
    private String idToken;

    @Column
    private String refreshToken;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String userId, String nickname, Role role) {
        this.userId = userId;
        this.nickname = nickname;
        this.role = role;
    }

    public User update(String nickname) {
        this.nickname = nickname;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}