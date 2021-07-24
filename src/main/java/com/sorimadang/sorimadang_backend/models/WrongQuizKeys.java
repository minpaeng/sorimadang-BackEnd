package com.sorimadang.sorimadang_backend.models;

import lombok.Getter;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
public class WrongQuizKeys implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name="id", nullable=false)
    private String user_id;

    @Column(name="stageNum", nullable=false)
    private int stageNum;

    @Column(name="quizNum", nullable=false)
    private int quizNum;

    public WrongQuizKeys(String user_id, int stageNum, int quizNum) {
        super();
        this.user_id = user_id;
        this.stageNum = stageNum;
        this.quizNum = quizNum;
    }
}


