package com.sorimadang.sorimadang_backend.repository;

import com.sorimadang.sorimadang_backend.domain.GameOXQuiz;
import com.sorimadang.sorimadang_backend.domain.GameOXQuizKeys;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameOXQuizRepository extends JpaRepository<GameOXQuiz, GameOXQuizKeys> {
}
