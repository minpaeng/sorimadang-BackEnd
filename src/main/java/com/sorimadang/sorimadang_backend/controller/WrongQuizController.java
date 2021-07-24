package com.sorimadang.sorimadang_backend.controller;

import com.sorimadang.sorimadang_backend.models.WrongQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class WrongQuizController {
    private final WrongQuizRepository wrongQuizRepository;

}
