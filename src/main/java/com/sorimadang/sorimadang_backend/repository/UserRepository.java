package com.sorimadang.sorimadang_backend.repository;

import com.sorimadang.sorimadang_backend.domain.User;
import com.sorimadang.sorimadang_backend.domain.WrongQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
