package com.uca.parcialfinalncapas.controller;

import com.uca.parcialfinalncapas.security.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private AuthenticationManager authManager;
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest req) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.correo(), req.password())
        );

        String token = jwtUtil.generateToken(
                new org.springframework.security.core.userdetails.User(
                        req.correo(),
                        "",
                        List.of()
                )
        );

        return ResponseEntity.ok(new AuthResponse(token));
    }
    
    public record AuthRequest(String correo, String password) {}
    public record AuthResponse(String token) {}
}
