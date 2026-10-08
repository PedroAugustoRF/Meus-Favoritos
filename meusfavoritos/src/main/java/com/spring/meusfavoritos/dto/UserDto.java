package com.spring.meusfavoritos.dto;

import java.time.LocalDate;

import com.spring.meusfavoritos.model.enumeration.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDto {
	@NotBlank
	private String nome;

	@NotNull
	private Integer idade;

	@NotNull
	private LocalDate aniversario;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String password;

	@NotNull
	private Role role;
}
