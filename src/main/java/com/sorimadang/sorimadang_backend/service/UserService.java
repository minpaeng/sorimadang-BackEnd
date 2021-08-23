package com.sorimadang.sorimadang_backend.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.sorimadang.sorimadang_backend.models.User;
import com.sorimadang.sorimadang_backend.models.UserRepository;
import com.sorimadang.sorimadang_backend.models.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public String update(String id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        //user.update(userRequestDto);
        return user.getUserId();
    }

    //id토큰 검증
    public String verifyToken(String idTokenString) throws GeneralSecurityException, IOException {
        HttpTransport transport = new NetHttpTransport();
        GsonFactory jsonFactory = GsonFactory.getDefaultInstance();

        //web client-id...이렇게박제하면안되는데..ㅠㅠ 어캐하는거람...^^
        String CLIENT_ID = "내 web client-id 입력";
        //GoogleIdTokenVerifier 객체 반환받기: idToken을 검증하기 위해 필요함
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                //백엔드에 접근하는 client_id(web client-id)
                .setAudience(Collections.singletonList(CLIENT_ID))
                // 아래 코드는 백엔드가 여러 개일 때 사용
                //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
                .build();

        // POST로 받은 idToken을 파라미터로 넘겨 토큰 검증
        GoogleIdToken idToken = verifier.verify(idTokenString);
        System.out.println("idToken = " + idToken);
        //검증 결과 유효한 토큰일 때 처리
        if (idToken != null) {
            System.out.println("not empty");
            //계정 정보가 담긴 payload
            GoogleIdToken.Payload payload = idToken.getPayload();

            // user identifier 가져오기(이메일만 저장할거라 따로 필요는 없지만 userID로도 개인 식별 가능)
            String userId = payload.getSubject();
            System.out.println("User ID: " + userId);

            // 프로필 정보 가자오기
            String email = payload.getEmail();

            // 여기부터 유저정보를 저장하거나 사용하는 코드 작성

            //이메일 반환해주기
            return email;
        } else {
            //검증 결과 유효하지 않은 토큰일 때
            return "Invalid ID token.";
        }
    }
}
