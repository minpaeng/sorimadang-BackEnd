package com.sorimadang.sorimadang_backend.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WrongQuizRepository extends JpaRepository<WrongQuiz, String> {
    List<WrongQuiz> findAllByUserId(String id);
}
