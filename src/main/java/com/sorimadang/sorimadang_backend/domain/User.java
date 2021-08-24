package com.sorimadang.sorimadang_backend.domain;

import com.sorimadang.sorimadang_backend.domain.Timestamped;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//자동 접속 시간 구현 추가 잊지말기
@Getter
@NoArgsConstructor
@Entity
public class User extends Timestamped {
    @Id
    private String email;

    @Column
    private String nickname;

    @Builder
    public User(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public String update(String nickname) {
        this.nickname = nickname;

        return this.nickname;
    }
}