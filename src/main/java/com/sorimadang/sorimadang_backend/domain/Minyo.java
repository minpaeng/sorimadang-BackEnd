package com.sorimadang.sorimadang_backend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Minyo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String soundUrl;

    @Column(nullable = false)
    String title;

    @JsonBackReference
    @ManyToOne
    Datatype dataType;
}
