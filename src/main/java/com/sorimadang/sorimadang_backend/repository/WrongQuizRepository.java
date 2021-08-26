package com.sorimadang.sorimadang_backend.repository;

import com.sorimadang.sorimadang_backend.domain.WrongQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WrongQuizRepository extends JpaRepository<WrongQuiz, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM wrongquiz as w WHERE w.email IN (:name) AND w.stage_num IN (:stage_num) AND w.quiz_num IN (:quiz_num)")
    List<WrongQuiz> findNote(@Param("name") String name, @Param("stage_num") int stage_num, @Param("quiz_num") int quiz_num);

    //List<WrongQuiz> findAllByUserId(String id);
}
