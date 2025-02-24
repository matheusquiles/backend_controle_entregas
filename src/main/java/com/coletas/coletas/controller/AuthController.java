package com.coletas.coletas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.model.Users;
import com.coletas.coletas.service.SecurityUserService;

@RestController
@RequestMapping("/api")
public class AuthController {

	@Autowired
	private SecurityUserService service;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Users loginRequest) {
		boolean isAuthenticated = service.login(loginRequest);
		if (isAuthenticated) {
			return ResponseEntity.ok("Login bem-sucedido");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
		}
	}
}
