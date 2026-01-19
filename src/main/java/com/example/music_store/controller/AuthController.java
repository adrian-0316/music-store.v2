package com.example.music_store.controller;

import com.example.music_store.dto.AuthResponse;
import com.example.music_store.dto.LoginRequest;
import com.example.music_store.dto.RegisterRequest;
import com.example.music_store.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid RegisterRequest request) {
        userService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody @Valid LoginRequest request) {
        String token = userService.login(request);
        return new AuthResponse(token);
    }
}