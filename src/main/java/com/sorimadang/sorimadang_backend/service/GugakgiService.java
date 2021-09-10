package com.sorimadang.sorimadang_backend.service;

import com.sorimadang.sorimadang_backend.domain.Datatype;
import com.sorimadang.sorimadang_backend.repository.DataTypeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GugakgiService {
    private final DataTypeRepository dataTypeRepository;

    public Datatype getAkgi(String type) {
        Datatype gugakgis = dataTypeRepository.findByDataType(type);
        return gugakgis;
    }
}
