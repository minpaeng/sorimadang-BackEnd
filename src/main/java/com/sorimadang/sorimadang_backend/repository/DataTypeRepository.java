package com.sorimadang.sorimadang_backend.repository;

import com.sorimadang.sorimadang_backend.domain.Datatype;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataTypeRepository extends JpaRepository<Datatype, Long> {
    Datatype findByDataType(String dataType);
}
