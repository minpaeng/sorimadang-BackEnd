package com.sorimadang.sorimadang_backend.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WrongQuizRepository extends JpaRepository<WrongQuiz, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM wrongquiz as w WHERE w.user_id IN (:name)")
    List<WrongQuiz> findByUserId(@Param("name") String name);

    //List<WrongQuiz> findAllByUserId(String id);
}
