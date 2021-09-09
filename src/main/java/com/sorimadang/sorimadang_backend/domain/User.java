package com.sorimadang.sorimadang_backend.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User extends Timestamped {
    @Id
    private String email;

    @Column
    private String nickname;

    @JsonManagedReference
    @OneToMany(mappedBy = "email")
    List<WrongQuiz> wrongQuizs;

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