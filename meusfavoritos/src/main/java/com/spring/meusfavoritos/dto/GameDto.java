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
public class GameDto {
	@NotBlank
	private String name;
	
	@NotBlank
	private String publisher;
	
	@NotBlank
	private String developer;
	
	@NotNull
	private Integer year;
}