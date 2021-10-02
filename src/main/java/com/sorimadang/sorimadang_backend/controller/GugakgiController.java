package com.sorimadang.sorimadang_backend.controller;

import com.sorimadang.sorimadang_backend.domain.Datatype;
import com.sorimadang.sorimadang_backend.domain.Gugakgi;
import com.sorimadang.sorimadang_backend.repository.GugakgiRepository;
import com.sorimadang.sorimadang_backend.service.GugakgiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GugakgiController {
    private final GugakgiRepository gugakgiRepository;
    private final GugakgiService gugakgiService;

    @GetMapping("/api/gugakgis")
    public List<Gugakgi> getGugakgis() {
        return gugakgiRepository.findAll();
    }

    @GetMapping("/api/gugakgi")
    public Datatype getGugakgi(@RequestParam String type) {
        return gugakgiService.getAkgi(type);
    }
}
