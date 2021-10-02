package com.sorimadang.sorimadang_backend.controller;

import com.sorimadang.sorimadang_backend.domain.Datatype;
import com.sorimadang.sorimadang_backend.domain.Gugakgi;
import com.sorimadang.sorimadang_backend.domain.Minyo;
import com.sorimadang.sorimadang_backend.repository.MinyoRepository;
import com.sorimadang.sorimadang_backend.service.MinyoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MinyoController {
    private final MinyoRepository minyoRepository;
    private final MinyoService minyoService;

    @GetMapping("/api/minyos")
    public List<Minyo> getMinyos() {
        return minyoRepository.findAll();
    }

    @GetMapping("/api/minyo")
    public Datatype getMinyo(@RequestParam String type) {
        return minyoService.getMinyo(type);
    }
}
