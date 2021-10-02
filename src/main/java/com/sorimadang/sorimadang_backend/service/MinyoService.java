package com.sorimadang.sorimadang_backend.service;

import com.sorimadang.sorimadang_backend.domain.Datatype;
import com.sorimadang.sorimadang_backend.repository.DataTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MinyoService {
    private final DataTypeRepository dataTypeRepository;

    public Datatype getMinyo(String type) {
        Datatype minyos = dataTypeRepository.findByDataType(type);
        return minyos;
    }
}
