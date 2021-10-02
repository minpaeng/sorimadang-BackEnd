package com.sorimadang.sorimadang_backend.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Datatype {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String dataType;

    @JsonManagedReference
    @OneToMany(mappedBy = "dataType")
    List<Gugakgi> gugakgi;

    @JsonManagedReference
    @OneToMany(mappedBy = "dataType")
    List<Minyo> minyo;
}
