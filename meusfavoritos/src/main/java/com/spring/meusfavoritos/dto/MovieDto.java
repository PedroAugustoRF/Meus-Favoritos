package com.spring.meusfavoritos.dto;

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
public class MovieDto {
	@NotBlank
	private String name;

	@NotBlank
	private String studio;

	@NotBlank
	private String director;

	@NotNull
	private Integer year;
}