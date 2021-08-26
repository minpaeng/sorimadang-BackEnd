package com.sorimadang.sorimadang_backend.controller;

import com.sorimadang.sorimadang_backend.domain.GameOXQuiz;
import com.sorimadang.sorimadang_backend.repository.GameOXQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GameOXQuizController {
    private final GameOXQuizRepository gameOXQuizRepository;

    @GetMapping("/api/ox-game/questions")
    public List<GameOXQuiz> getCourses() {
        return gameOXQuizRepository.findAll();
    }

    /*@PutMapping("/api/courses/{id}") //{id}는 변수 id가 유동적으로 변함을 나타냄
    public Long updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto) {
        return courseService.update(id, requestDto);
    }*/
}
