package com.sorimadang.sorimadang_backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class User {
    @Id
    @Column(name = "userId")
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column
    private String nickname;

    public User(String userId, String password, String nickname) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
    }

    public User(UserRequestDto userRequestDto) {
        this.userId = userRequestDto.getUserId();
        this.password = userRequestDto.getPassword();
        this.nickname = userRequestDto.getNickname();
    }

    public void update(UserRequestDto userRequestDto) {
        this.nickname = userRequestDto.getNickname();
    }

}
