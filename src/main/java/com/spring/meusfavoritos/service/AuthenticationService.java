package com.spring.meusfavoritos.service;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.meusfavoritos.config.TokenProvider;
import com.spring.meusfavoritos.dto.LoginRequestDto;
import com.spring.meusfavoritos.dto.RegisterRequestDto;
import com.spring.meusfavoritos.dto.TokenResponseDto;
import com.spring.meusfavoritos.model.UserModel;
import com.spring.meusfavoritos.model.enumeration.Role;
import com.spring.meusfavoritos.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final TokenProvider tokenProvider;
	
	@Value("${jwt.expiration}")
	private long expiresIn;

	public void register(RegisterRequestDto dto) throws BadRequestException {
		UserModel user = repository.findByEmail(dto.getEmail())
				.orElse(null);
		
		if(user != null) {
			throw new BadRequestException("Usuário já cadastrado com esse email");
		}
		
		repository.save(UserModel.builder()
				.nome(dto.getNome())
				.email(dto.getEmail())
				.password(passwordEncoder.encode(dto.getPassword()))
				.role(Role.USER)
				.build());
	}
	
	public TokenResponseDto login(LoginRequestDto dto) throws BadRequestException {
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
			
			String token = tokenProvider.gerarToken(authentication);
			
			return new TokenResponseDto(token, expiresIn);
		}catch(BadCredentialsException bce) {
			throw new BadCredentialsException("Credenciais inválidas");
		}catch(Exception e) {
			throw e;
		}
		
	}
}
