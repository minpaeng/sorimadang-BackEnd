package com.sorimadang.sorimadang_backend.service;

import com.sorimadang.sorimadang_backend.models.User;
import com.sorimadang.sorimadang_backend.models.UserRepository;
import com.sorimadang.sorimadang_backend.models.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public String update(String id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        user.update(userRequestDto);
        return user.getUserId();
    }
}
