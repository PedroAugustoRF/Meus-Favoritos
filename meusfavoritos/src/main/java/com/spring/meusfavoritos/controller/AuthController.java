package com.spring.meusfavoritos.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.meusfavoritos.dto.LoginRequestDto;
import com.spring.meusfavoritos.dto.RegisterRequestDto;
import com.spring.meusfavoritos.dto.TokenResponseDto;
import com.spring.meusfavoritos.service.AuthenticationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

	private final AuthenticationService service;

	@PostMapping("/register")
	public void register(@RequestBody @Valid RegisterRequestDto dto) throws BadRequestException {
		service.register(dto);
	}

	@PostMapping("/login")
	public TokenResponseDto login(@RequestBody @Valid LoginRequestDto dto) throws BadRequestException {
		return service.login(dto);
	}
}
