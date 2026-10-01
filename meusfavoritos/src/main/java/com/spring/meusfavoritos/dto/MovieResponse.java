package com.spring.meusfavoritos.dto;

import com.spring.meusfavoritos.model.MovieModel;

public record MovieResponse(Long id, String name, String studio, String director, Integer year) {

	public static MovieResponse from(MovieModel m) {
		return new MovieResponse(m.getId(), m.getName(), m.getStudio(), m.getDirector(), m.getYear());
	}
}