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
public class MusicDto {
	@NotBlank
	private String name;

	@NotNull
	private Integer trackNumber;

	@NotBlank
	private String artist;

	@NotBlank
	private String album;

	@NotBlank
	private String publisher;

	@NotNull
	private Integer year;
}