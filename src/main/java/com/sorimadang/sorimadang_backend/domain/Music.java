package com.sorimadang.sorimadang_backend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long serialId;

    @Column(nullable = false)
    String region;

    @Column(nullable = false)
    String soundUrl;

    @Column(nullable = false)
    String title;

    @JsonBackReference
    @ManyToOne
    Datatype dataType;
}
