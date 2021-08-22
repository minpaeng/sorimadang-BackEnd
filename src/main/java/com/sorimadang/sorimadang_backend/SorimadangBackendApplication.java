package com.sorimadang.sorimadang_backend;

import com.sorimadang.sorimadang_backend.models.*;
import com.sorimadang.sorimadang_backend.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SorimadangBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SorimadangBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserService userService) {
        return (args) -> {
            //System.out.println("성공");
            String idToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjZlZjRiZDkwODU5MWY2OTdhOGE5Yjg5M2IwM2U2YTc3ZWIwNGU1MWYiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiI2NTgxODk1ODc5ODQtb2Jqb3FoZjUydXRxaDRoc2toczY1Y3FibG5wZmQxNXIuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiI2NTgxODk1ODc5ODQtMHA0dTNlNTgxbWluZ3M3YWhzbG5udXVndnRkcTllNXAuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMTcxNzM3MjcxNjU1NTk5NTU1MzgiLCJlbWFpbCI6Imt3ZW5tamtAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsIm5hbWUiOiLqtozrr7zsoJUiLCJwaWN0dXJlIjoiaHR0cHM6Ly9saDMuZ29vZ2xldXNlcmNvbnRlbnQuY29tL2EvQUFUWEFKekc0RkZwVmw3MW5wWG9HUWxmMkJLMmJUU2Frejc3UzNkT0wxZlY9czk2LWMiLCJnaXZlbl9uYW1lIjoi66-87KCVIiwiZmFtaWx5X25hbWUiOiLqtowiLCJsb2NhbGUiOiJrbyIsImlhdCI6MTYyOTYxNTU1NSwiZXhwIjoxNjI5NjE5MTU1fQ.r9_UgEv9mlsrECWPytgK9F-fNxoPmUgwjgPfAcdVOqrzr5gMbqV3opmwSCw_YnZgMu4d0AXOl1e38uPl4NZS81_4is8F6efrd59Ly96HiqTm_bfAK-LUgS5UlCxIXfIdkGIWYJshQpV-vVJFqTuUA4RC2TGJcju3wf_14cyrUjGjBpbUP8blSrZVmh7JQcKOU2LmZ4l0_c5kACb4AS3DWp0efVvzR6sYF_erB-Jlgl4uhIetxPFaz5X9c1i71abXDGjRBpctza-poi2Jqe19e6Kk5U2C6R-0P4yNFgDyznmC4QjyVWmIBJSAR9wMgmv53KT3Cf91XKNaKYoC0ZryvQ";
            userService.verifyToken(idToken);
        };
    }
}