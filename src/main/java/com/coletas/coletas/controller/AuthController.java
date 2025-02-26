package com.coletas.coletas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.model.Users;
import com.coletas.coletas.service.SecurityUserService;
import com.coletas.coletas.token.AuthResponse;
import com.coletas.coletas.token.JwtTokenUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private  AuthenticationManager authenticationManager;
	@Autowired
    private  SecurityUserService securityUserService;
	@Autowired
    private  JwtTokenUtil jwtTokenUtil;

    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users loginRequest) {
        try {
            System.out.println("🔒 Tentando autenticar usuário: " + loginRequest.getUserKey());

            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserKey(), loginRequest.getPassword())  // <---- ERRO AQUI! 
            );

            System.out.println("✅ Autenticação bem-sucedida!");

            final UserDetails userDetails = securityUserService.loadUserByUsername(loginRequest.getUserKey());
            final String token = jwtTokenUtil.generateToken(userDetails.getUsername());

            return ResponseEntity.ok(new AuthResponse(token));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro no servidor");
        }
    }
}
