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
    @Column(name = "user_id")
    private String user_id;

    @Column(nullable = false)
    private String password;

    @Column
    private String nickname;

    public User(String user_id, String password, String nickname) {
        this.user_id = user_id;
        this.password = password;
        this.nickname = nickname;
    }

    public User(UserRequestDto userRequestDto) {
        this.user_id = userRequestDto.getUser_id();
        this.password = userRequestDto.getPassword();
        this.nickname = userRequestDto.getNickname();
    }

    public void update(UserRequestDto userRequestDto) {
        this.nickname = userRequestDto.getNickname();
    }

}
