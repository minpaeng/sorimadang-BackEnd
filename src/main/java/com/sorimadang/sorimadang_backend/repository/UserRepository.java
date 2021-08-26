package com.sorimadang.sorimadang_backend.repository;

import com.sorimadang.sorimadang_backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
