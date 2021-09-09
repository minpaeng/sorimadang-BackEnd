package com.sorimadang.sorimadang_backend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Gugakgi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String akgiName;

    @Column(nullable = false)
    String imageUrl;

    @Column(nullable = false)
    String soundUrl;

    @JsonBackReference
    @ManyToOne
    Datatype dataType;
}
